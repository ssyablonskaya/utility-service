package com.solvd.utilityservice.organization.staff;

public enum FoodMenu {

    MENU1("Menu 1"),
    MENU2("Menu 2"),
    MENU3("Menu 3");

    private final String title;

    FoodMenu (String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Food menu: " + title + "; ";
    }

    public String getTitle() {
        return title;
    }

}
