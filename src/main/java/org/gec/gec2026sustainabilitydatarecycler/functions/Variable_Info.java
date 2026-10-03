package org.gec.gec2026sustainabilitydatarecycler.functions;
import java.util.*;

public class Variable_Info {
    String var_list;

    String description;
    String notes;

    public String getVar_List(){
        return var_list;
    }
    public void setVar_List(String var_List){
        if(var_List.startsWith(" ")) var_List = var_List.substring(1);
        this.var_list = var_List;
    }

    public String getDescription() {
        return description;
    }
    public void setDescrition(String desc) {
        if(desc.length() < 5){
            desc = "";
        }
        if(desc.endsWith("\"")) desc = desc.substring(0, desc.length()-1);
        if(desc.startsWith(" ")) desc = desc.substring(1);
        this.description = desc;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        if(notes.startsWith(" ")) notes = notes.substring(1);
        if(notes.length() < 5){
            notes = "";
        }
        this.notes = notes;
    }

}
