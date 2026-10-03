package org.gec.gec2026sustainabilitydatarecycler;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.gec.gec2026sustainabilitydatarecycler.functions.*;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    @FXML private Label readmelabel, csvlabel, jsonlabel;
    @FXML private TextField titleField;
    @FXML private TableView<String[]> dataTable, Peopletable, Vocabtable;

    private File csvFile;
    private File readmeFile;
    private String jsonResult;      // the held JSON, null until RUN succeeds

    @FXML private void initialize() {
        readmelabel.setText("No README");
        csvlabel.setText("No CSV");
        jsonlabel.setText("");
        // editing the title makes the held JSON out of date
        titleField.textProperty().addListener((obs, o, n) -> clearResult());
    }

    private void clearResult() {
        jsonResult = null;
        jsonlabel.setText("");
    }
//select readme
    @FXML private void chooseReadme() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose README");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt"));
        File f = fc.showOpenDialog(readmelabel.getScene().getWindow());
        if (f == null) return;                       // user cancelled
        readmeFile = f;
        readmelabel.setText(f.getName());
        clearResult();
    }
//select csv
    @FXML private void chooseCsv() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose CSV");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files", "*.csv"));
        File f = fc.showOpenDialog(csvlabel.getScene().getWindow());
        if (f == null) return;  //use cancelled
        csvFile = f;
        csvlabel.setText(f.getName());
        clearResult();
    }

    @FXML
    private void RUN() {
        if (csvFile == null) {
            jsonlabel.setText("Choose a CSV first");
            return;
        }
        try {
            // README
            README_Data readmeInfo = null;
            ArrayList<Variable_Info> vars = new ArrayList<>();
            ArrayList<People_Data> people = new ArrayList<>();
            if (readmeFile != null) {
                README_Reader rr = new README_Reader();
                readmeInfo = new README_Data();
                rr.readData(readmeFile.getPath(), readmeInfo);
                rr.readVariableData(readmeFile.getPath(), vars);
                rr.readPeopleData(readmeFile.getPath(), people);
            }

            //  paste the README title into the title box if it is empty
            String title = titleField.getText();
            if ((title == null || title.isBlank()) && readmeInfo != null && readmeInfo.getTitle() != null) {
                title = readmeInfo.getTitle();
                titleField.setText(title);
            }

            //  build and hold the JSON
            jsonResult = CSVtoJSON.toJson(csvFile, readmeFile, title, readmeInfo, vars, people);

            //  paste the CSV into the data table
            List<String[]> rows = new CSVreader().readCSV(csvFile.getPath());
            String[] header = rows.get(0);
            header[0] = header[0].replace("\uFEFF", "");
            fillTable(dataTable, header, rows.subList(1, rows.size()));

            //  paste the people into their table
            List<String[]> peopleRows = new ArrayList<>();
            for (People_Data p : people) {
                peopleRows.add(new String[]{p.getName(), p.getID(), p.getInstitution(), p.getAddress(), p.getEmail()});
            }
            fillTable(Peopletable, new String[]{"Name", "ORCID", "Institution", "Address", "Email"}, peopleRows);

            //  paste the vocabulary into its table
            List<String[]> vocabRows = new ArrayList<>();
            for (Variable_Info v : vars) {
                vocabRows.add(new String[]{v.getVar_List(), v.getDescription(), v.getNotes()});
            }
            fillTable(Vocabtable, new String[]{"Variable", "Description", "Notes"}, vocabRows);

            jsonlabel.setText("JSON ready - click DOWNLOAD JSON");
        } catch (Exception ex) {
            ex.printStackTrace();
            clearResult();
            new Alert(Alert.AlertType.ERROR, "Failed: " + ex.getMessage()).show();
        }
    }

    // fills any of the three tables: removes the placeholder C1/C2, then one column per header name
    private void fillTable(TableView<String[]> table, String[] header, List<String[]> rows) {
        table.getColumns().clear();
        table.getItems().clear();

        for (int j = 0; j < header.length; j++) {
            final int col = j;
            TableColumn<String[], String> tc = new TableColumn<>(header[j].trim());
            tc.setPrefWidth(header.length <= 5 ? 110 : 90);
            tc.setCellValueFactory(c -> {
                String[] row = c.getValue();
                String v = (col < row.length && row[col] != null) ? row[col].trim() : "";
                return new SimpleStringProperty(v.equals(".") ? "—" : v);
            });
            table.getColumns().add(tc);
        }
        table.getItems().addAll(rows);
    }

    @FXML private void downloadJSON() {
        if (jsonResult == null) {
            jsonlabel.setText("Click RUN first");   //make sure run button works first to run CSVtoJSON
            return;
        }
        FileChooser fc = new FileChooser();
        fc.setTitle("Save JSON");               //inform user
        fc.setInitialFileName("output.json");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files", "*.json"));
        File out = fc.showSaveDialog(jsonlabel.getScene().getWindow());
        if (out == null) return;     //if problem display error
        try {
            Files.writeString(out.toPath(), jsonResult);
            jsonlabel.setText("Saved " + out.getName());
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, "Could not save: " + ex.getMessage()).show();
        }
    }

    // fills your TableView with the CSV, one column per header name
    private void showTable() throws Exception {
        List<String[]> rows = new CSVreader().readCSV(csvFile.getPath());
        String[] header = rows.get(0);
        header[0] = header[0].replace("\uFEFF", "");     // strip the hidden BOM

        dataTable.getColumns().clear();                  // removes the placeholder C1 and C2
        dataTable.getItems().clear();

        for (int j = 0; j < header.length; j++) {
            final int col = j;                           // must be final for the lambda
            TableColumn<String[], String> tc = new TableColumn<>(header[j].trim());
            tc.setCellValueFactory(c -> {
                String[] row = c.getValue();
                String v = col < row.length ? row[col].trim() : "";
                return new SimpleStringProperty(v.equals(".") ? "—" : v);   // missing shows as a dash
            });
            dataTable.getColumns().add(tc);
        }
        dataTable.getItems().addAll(rows.subList(1, rows.size()));          // skip the header row
    }
}



