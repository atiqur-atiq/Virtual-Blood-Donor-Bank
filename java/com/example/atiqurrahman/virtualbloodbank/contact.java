package com.example.atiqurrahman.virtualbloodbank;

/**
 * Created by AtiqurRahman on 4/14/2017.
 */

public class contact {

    private String name,blod,cell,location;
    public contact(String name, String blod,String cell,String location){
        this.setName(name);
        this.setBlod(blod);
        this.setCell(cell);
        this.setLocation(location);
    }
    public String getName(){
     return name;
    }

    public void setName(String nam) {
        name = nam;
    }
    public String getBlod(){
        return blod;
    }

    public void setBlod(String bld) {
        blod = bld;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cel) {
        cell = cel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String loca) {
        location = loca;
    }
}
