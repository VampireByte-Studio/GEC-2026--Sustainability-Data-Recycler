package org.gec.gec2026sustainabilitydatarecycler.functions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class CSVtoJSON {
    public static void main(String[] args) throws Exception {
        //read csv
        CSVreader reader = new CSVreader();
        List<String[]> rows = reader.readCSV();
        //values
        String csvFilename = "csvtest";
        String readmeFilename = "filenametest";
        String title = "researchnametest";
        String[] header = rows.get(0);
        int num_Var = header.length;
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
                if (cell.isEmpty()) {
                    sb.append("null");                                   // empty cell
                } else if (isNumber) {
                    sb.append(cell);
                } else {
                    sb.append("\"").append(cell.replace("\"", "\\\"")).append("\"");
                }

            }
            sb.append("}");
            if (i < rows.size() - 1) sb.append(",");
        }

        sb.append("  ]\n");
        sb.append("}\n");
        //write file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.json"))) {
                bw.write(sb.toString());
            }

            System.out.println("Wrote " + (rows.size() - 1) + " rows to output.json");
        }


    }

