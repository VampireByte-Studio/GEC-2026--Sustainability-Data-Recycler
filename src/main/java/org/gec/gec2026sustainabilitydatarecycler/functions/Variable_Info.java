package org.gec.gec2026sustainabilitydatarecycler.functions;
import java.util.*;

public class Variable_Info {
    int num_Var;
    int num_Case;
    ArrayList<String> var_list = new ArrayList<>();

    String descrition;
    String notes;

    public int getNum_Var() {
        return num_Var;
    }
    public void setNum_Var(int num_Var) {
        this.num_Var = num_Var;
    }

    public int getNum_Case() {
        return num_Case;
    }
    public void setNum_Case(int num_Case) {
        this.num_Case = num_Case;
    }

    public ArrayList<String> getVar_List(){
        return var_list;
    }
    public void setVar_List(String var_List){
        if(var_List.contains(" ")){
            String[] temp = var_List.split(" ");
            this.var_list.add(temp[1]);
        }else this.var_list.add(var_List);
    }

    public String getDescrition() {
        return descrition;
    }
    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

}
