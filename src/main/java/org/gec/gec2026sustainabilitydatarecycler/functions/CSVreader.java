package org.gec.gec2026sustainabilitydatarecycler.functions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CSVreader {
    /*temp values for testing
    int num_Var = 0;
    int num_Case = 0;
    String var_list[]; */
    String filePath = "C:\\Users\\theme\\IdeaProjects\\GEC-2026--Sustainability-Data-Recycler\\src\\main\\java\\org\\gec\\gec2026sustainabilitydatarecycler\\functions\\CowEnergyBalanceData-1.csv"; //temp
    File file = new File(filePath);
    public void readCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println(Arrays.toString(values)); //print to terminal for testing
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }


}
