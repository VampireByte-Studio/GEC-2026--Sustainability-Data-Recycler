package org.gec.gec2026sustainabilitydatarecycler.functions;

import java.io.*;
import java.util.*;

public class README_Reader {
    public void readData(String filepath, README_Data B) throws IOException {
        File file = new File("src/100A_README.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        int check = 0;

        while ((line = reader.readLine()) != null) {
            if (line.contains("Number of variables: ")) { //Finds specific line
                String[] temp = line.split(": "); //Splits the line into two Strings in an array
                B.setNum_Var(Integer.parseInt(temp[1])); //Set the variable in A as an int
            } else if (line.contains("Number of cases/rows: ")) {
                String[] temp = line.split(": ");
                B.setNum_Case(Integer.parseInt(temp[1]));
            }
        }
    }
    public void readVariableData(String filepath, ArrayList<Variable_Info> A) throws IOException {
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        int check = 0;
        Variable_Info Temp_info = null;

        while ((line = reader.readLine()) != null) {
            if (line.contains("Variable List:")) {
                check = 1;
                continue;
            }
            if (check == 0) continue;

                if(line.contains("Name:")) {
                    Temp_info = new Variable_Info();
                    String[] temp = line.split(":");
                    Temp_info.setVar_List(temp[1]);
                    A.add(Temp_info);
                }
                if(line.contains("Description:")) {
                    String[] temp = line.split(":");
                    Temp_info.setDescrition(temp[1]);
                }
                if(line.contains("Notes:")) {
                    String[] temp = line.split(":");
                    Temp_info.setNotes(temp[1]);
                }
        }
    }

    public void readPeopleData(String filepath, ArrayList<People_Data> C) throws IOException {
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        People_Data Temp_info = null;

        while ((line = reader.readLine()) != null) {
            if(line.contains("Name:")) {
                Temp_info = new People_Data();
                String[] temp = line.split(":");
                Temp_info.setName(temp[1]);
                C.add(Temp_info);
            }
            if(line.contains("ORCID:")) {
                String[] temp = line.split(":");
                Temp_info.setID(temp[1]);
            }
            if(line.contains("Institution:")) {
                String[] temp = line.split(":");
                Temp_info.setInstitution(temp[1]);
            }
            if(line.contains("Address:")) {
                String[] temp = line.split(":");
                Temp_info.setAddress(temp[1]);
            }
            if(line.contains("Email:")) {
                String[] temp = line.split(":");
                Temp_info.setEmail(temp[1]);
            }
            if(line.contains("Date")) {
                break;
            }
        }
    }
}

