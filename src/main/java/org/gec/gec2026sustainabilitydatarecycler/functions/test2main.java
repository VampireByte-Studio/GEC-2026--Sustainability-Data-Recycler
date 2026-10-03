package org.gec.gec2026sustainabilitydatarecycler.functions;

import java.io.IOException;
import java.util.*;

public class test2main {
    public static void main(String[] args) throws IOException {
        README_Reader reader =  new README_Reader();
        README_Data B = new README_Data();

        reader.readData("src/100A_README.txt", B);

        ArrayList<Variable_Info> A = new ArrayList<>();

        reader.readVariableData("src/100A_README.txt", A);
        System.out.println(B.num_Var);
        System.out.println(B.num_Case);
        for(int j=0;j<A.size();j++) {
                System.out.println(A.get(j).var_list);
                System.out.println(A.get(j).description);
                System.out.println(A.get(j).notes + "\n");
        }
    }
}
