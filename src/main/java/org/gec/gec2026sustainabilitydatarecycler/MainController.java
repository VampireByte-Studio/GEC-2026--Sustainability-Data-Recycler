package org.gec.gec2026sustainabilitydatarecycler;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.gec.gec2026sustainabilitydatarecycler.functions.CSVreader;
import org.gec.gec2026sustainabilitydatarecycler.functions.CSVtoJSON;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class MainController {
    @FXML private Label readmelabel, csvlabel, jsonlabel;
    @FXML private TextField titleField;
    @FXML private TableView<String[]> dataTable;

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

    @FXML private void chooseCsv() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose CSV");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files", "*.csv"));
        File f = fc.showOpenDialog(csvlabel.getScene().getWindow());
        if (f == null) return;
        csvFile = f;
        csvlabel.setText(f.getName());
        clearResult();
    }

    @FXML private void RUN() {
        if (csvFile == null) {
            jsonlabel.setText("Choose a CSV first");
            return;
        }
        try {
            jsonResult = CSVtoJSON.toJson(csvFile, readmeFile, titleField.getText());
            showTable();
            jsonlabel.setText("JSON ready - click DOWNLOAD JSON");
        } catch (Exception ex) {
            ex.printStackTrace();
            clearResult();
            new Alert(Alert.AlertType.ERROR, "Failed: " + ex.getMessage()).show();
        }
    }

    @FXML private void downloadJSON() {
        if (jsonResult == null) {
            jsonlabel.setText("Click RUN first");
            return;
        }
        FileChooser fc = new FileChooser();
        fc.setTitle("Save JSON");
        fc.setInitialFileName("output.json");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files", "*.json"));
        File out = fc.showSaveDialog(jsonlabel.getScene().getWindow());
        if (out == null) return;
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