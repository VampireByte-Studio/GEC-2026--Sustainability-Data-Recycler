package org.gec.gec2026sustainabilitydatarecycler.functions;

public class CSVtoJSON {
    public static void main(String[] args) throws Exception {
        //read csv
        CSVreader reader = new CSVreader();
        reader.readCSV();
        //build JSON
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

    }
}
