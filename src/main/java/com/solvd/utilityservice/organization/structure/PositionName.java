package com.solvd.utilityservice.organization.structure;

public enum PositionName {

    ACCOUNTANT("Accountant"),
    REPAIRER("Repairer"),
    PLUMBER("Plumber");

    private final String title;

    PositionName (String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Position name: " + title + "; ";
    }

    public String getTitle() {
        return title;
    }

}
