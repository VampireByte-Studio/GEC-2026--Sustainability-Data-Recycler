package org.gec.gec2026sustainabilitydatarecycler.functions;

import java.io.File;                                   // CHANGED (replaces BufferedWriter/FileWriter)
import java.nio.file.Files;                            // CHANGED (only used by the test main below)
import java.util.List;

public class CSVtoJSON {

    // CHANGED: was "public static void main(String[] args)"; now it takes the inputs and returns the JSON text
    public static String toJson(File csvFile, File readmeFile, String title) throws Exception {
        //read csv
        CSVreader reader = new CSVreader();
        List<String[]> rows = reader.readCSV(csvFile.getPath());
        //values
        String csvFilename = csvFile.getName();
        String readmeFilename = readmeFile == null ? "" : readmeFile.getName();
        title = title.replace("\\", "\\\\").replace("\"", "\\\"");
        String[] header = rows.get(0);
        int num_Var = header.length;
        header[0] = header[0].replace("\uFEFF", "");
        //build JSON
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        // metadata
        sb.append("  \"metadata\": {\n");
        sb.append("    \"title\": \"").append(title).append("\",\n");
        sb.append("    \"csv_source\": \"").append(csvFilename).append("\",\n");
        sb.append("    \"readme_source\": \"").append(readmeFilename).append("\",\n");
        sb.append("    \"rows\": ").append(rows.size() - 1).append(",\n");
        sb.append("    \"vars\": ").append(num_Var).append("\n");
        sb.append("  },\n");

        //data
        sb.append("  \"data\": [\n");
        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);
            sb.append("    {");
            for (int j = 0; j < header.length; j++) {
                if (j > 0) sb.append(", ");
                String cell;

                if (j < row.length) {
                    cell = row[j].trim();
                } else {
                    cell = "";
                }
                sb.append("\"").append(header[j].trim()).append("\": ");
                boolean isNumber;
                try {
                    Double.parseDouble(cell);
                    isNumber = true;
                } catch (NumberFormatException e) {
                    isNumber = false;
                }
                if (cell.isEmpty() || cell.equals(".")) {
                    sb.append("null");
                } else if (isNumber) {
                    sb.append(cell);
                } else {
                    sb.append("\"").append(cell.replace("\\", "\\\\").replace("\"", "\\\"")).append("\"");
                }

            }
            sb.append("}");
            if (i < rows.size() - 1) sb.append(",");
            sb.append("\n");
        }

        sb.append("  ]\n");
        sb.append("}\n");
        return sb.toString();
    }


    public static void main(String[] args) throws Exception {
        String json = toJson(new File("CowEnergyBalanceData-1.csv"), null, "Test title");
        Files.writeString(java.nio.file.Path.of("output.json"), json);
        System.out.println("Done");
    }
}