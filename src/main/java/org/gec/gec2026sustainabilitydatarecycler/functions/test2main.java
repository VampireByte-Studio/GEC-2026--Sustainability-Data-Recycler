package org.gec.gec2026sustainabilitydatarecycler.functions;

import java.io.IOException;

public class test2main {
    public static void main(String[] args) throws IOException {
        README_Reader reader =  new README_Reader();
        Variable_Info A = new Variable_Info();

        reader.readA("src/100A_README.txt", A);
        System.out.println(A.num_Var);
        System.out.println(A.num_Case);
        for (int i = 0; i < A.var_list.size(); i++) {
            System.out.println(A.var_list.get(i));
        }
    }
}
