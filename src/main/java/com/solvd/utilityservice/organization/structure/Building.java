package com.solvd.utilityservice.organization.structure;

public class Building {

    private static Building instance;
    private String address;

    private Building(String address) {
        this.address = address;
    }

    public static Building getInstance(String address) {
        if (instance == null) {
            instance = new Building(address);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Building {" +
                "address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
