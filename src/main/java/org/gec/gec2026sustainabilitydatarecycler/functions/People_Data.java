package org.gec.gec2026sustainabilitydatarecycler.functions;

public class People_Data {
    String name;
    String ID;
    String institution;
    String address;
    String email;

    public String getName(){
        return name;
    }
    public void setName(String name){
        if(name.startsWith(" ")) name = name.substring(1);
        this.name=name;
    }

    public String getID(){
        return ID;
    }
    public void setID(String ID){
        if(ID.startsWith(" ")) ID = ID.substring(1);
        this.ID=ID;
    }

    public String getInstitution(){
        return institution;
    }
    public void setInstitution(String institution){
        if(institution.startsWith(" ")) institution = institution.substring(1);
        this.institution=institution;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        if(address.startsWith(" ")) address = address.substring(1);
        this.address=address;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        if(email.startsWith(" ")) email = email.substring(1);
        this.email=email;
    }
}
