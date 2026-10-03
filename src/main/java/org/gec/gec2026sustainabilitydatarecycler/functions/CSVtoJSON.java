package org.gec.gec2026sustainabilitydatarecycler.functions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class CSVtoJSON {
    public static void main(String[] args) throws Exception {
        //values
        String csvFilename = "csvtest";
        String readmeFilename = "filenametest";
        String title ="researchnametest";
        int num_Var =0;
        //read csv
        CSVreader reader = new CSVreader();
        List<String[]> rows = reader.readCSV();
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
       // sb.append("  \"data\": [\n");
       // for(int i =1; i>)

        //write file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.json"))) {
            bw.write(sb.toString());
        }

        System.out.println("Wrote " + (rows.size()-1) + " rows to output.json");
    }



}
