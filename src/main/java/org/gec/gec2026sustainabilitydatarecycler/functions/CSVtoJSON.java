package org.gec.gec2026sustainabilitydatarecycler.functions;

import java.io.File;                                   // CHANGED (replaces BufferedWriter/FileWriter)
import java.nio.file.Files;                            // CHANGED (only used by the test main below)
import java.util.List;

public class CSVtoJSON {

    // CHANGED: was "public static void main(String[] args)"; now it takes the inputs and returns the JSON text
    public static String toJson(File csvFile, File readmeFile, String title,
                                README_Data info, List<Variable_Info> vars, List<People_Data> people) throws Exception {
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
        sb.append("    \"title\": ").append(q(title)).append(",\n");
        sb.append("    \"csv_source\": ").append(q(csvFilename)).append(",\n");
        sb.append("    \"readme_source\": ").append(q(readmeFilename)).append(",\n");
        sb.append("    \"rows\": ").append(rows.size() - 1).append(",\n");
        sb.append("    \"vars\": ").append(num_Var).append(",\n");
        sb.append("    \"doi\": ").append(q(info == null ? null : info.getDOI())).append(",\n");
        sb.append("    \"description\": ").append(q(info == null ? null : info.getDecription_of_data())).append(",\n");
        sb.append("    \"date_of_collection\": ").append(q(info == null ? null : String.valueOf(info.getDate_of_collection()))).append(",\n");
        sb.append("    \"geographic_location\": ").append(q(info == null ? null : info.getGeographic_location())).append(",\n");
        sb.append("    \"funding_info\": ").append(q(info == null ? null : info.getFunding_info())).append("\n");
        sb.append("  },\n");

        // people
        sb.append("  \"people\": [\n");
        if (people != null) {
            for (int i = 0; i < people.size(); i++) {
                People_Data p = people.get(i);
                sb.append("    {\"name\": ").append(q(p.getName()))
                        .append(", \"orcid\": ").append(q(p.getID()))
                        .append(", \"institution\": ").append(q(p.getInstitution()))
                        .append(", \"address\": ").append(q(p.getAddress()))
                        .append(", \"email\": ").append(q(p.getEmail())).append("}");
                if (i < people.size() - 1) sb.append(",");
                sb.append("\n");
            }
        }
        sb.append("  ],\n");

        // vocabulary
        sb.append("  \"vocabulary\": [\n");
        if (vars != null) {
            for (int i = 0; i < vars.size(); i++) {
                Variable_Info v = vars.get(i);
                sb.append("    {\"name\": ").append(q(v.getVar_List()))
                        .append(", \"description\": ").append(q(v.getDescription()))
                        .append(", \"notes\": ").append(q(v.getNotes())).append("}");
                if (i < vars.size() - 1) sb.append(",");
                sb.append("\n");
            }
        }
        sb.append("  ],\n");

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
                //detect if value is a number
                boolean isNumber;
                try {
                    Double.parseDouble(cell);
                    isNumber = true;
                } catch (NumberFormatException e) {
                    isNumber = false;
                }
                //check what is in the cell, if its a number we can just append,
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


        // wraps text in quotes and escapes it; null becomes the JSON value null
        private static String q(String s) {
            if (s == null) return "null";
            return "\"" + s.replace("\\", "\\\\").replace("\"", "\\\"")
                    .replace("\r", "").replace("\n", "\\n").replace("\t", "\\t") + "\"";
        }
}