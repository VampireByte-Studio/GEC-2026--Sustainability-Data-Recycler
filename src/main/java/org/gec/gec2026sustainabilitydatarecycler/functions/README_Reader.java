package org.gec.gec2026sustainabilitydatarecycler.functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class README_Reader {
    public void readA(String filepath, Variable_Info A) throws IOException {
        File file = new File("src/100A_README.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        int check = 0;

        while ((line = reader.readLine()) != null) {
            if (check == 0){
              if(line.contains("Name: ")){
                  //String[] temp = line.split("Name: ");

              }
            }
            if (line.contains("Number of variables: ")) { //Finds specific line
                String[] temp = line.split(": "); //Splits the line into two Strings in an array
                A.setNum_Var(Integer.parseInt(temp[1])); //Set the variable in A as an int
            } else if (line.contains("Number of cases/rows: ")) {
                String[] temp = line.split(": ");
                A.setNum_Case(Integer.parseInt(temp[1]));
            } else if (line.contains("Variable List:")) {
                check = 1;
            }
            if (check == 1 && line.contains("Name:")) {
                String[] temp = line.split(":");
                A.setVar_List(temp[1]);
            }
        }
    }
}

