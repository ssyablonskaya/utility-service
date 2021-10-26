package com.solvd.utilityservice.organization.service;

public class InsideWork extends Service {

    public InsideWork(String name, int price, int doTime) {
        super(name, price, doTime);
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + "; Price: " + super.getPrice() + " rubles; Time to do: " + super.getDoTime()
                + " hours.";
    }
}
