package org.gec.gec2026sustainabilitydatarecycler.functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVreader {

    public List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;              // skip empty lines
                rows.add(line.split(",", -1));             // -1 to keep empty cells at the end of a row
            }
        }
        return rows;
    }
}