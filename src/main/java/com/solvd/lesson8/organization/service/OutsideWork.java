package com.solvd.lesson8.organization.service;

import java.util.Objects;

public class OutsideWork extends Service {

    private int minTemperatureOutside;

    public OutsideWork(String name, int price, int doTime, int minTemperatureOutside) {
        super(name, price, doTime);
        this.minTemperatureOutside = minTemperatureOutside;
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + "; Price: " + super.getPrice() + " rubles; Time to do: " + super.getDoTime()
                + " hours. The lowest possible temperature outside: " + minTemperatureOutside + " c";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OutsideWork that = (OutsideWork) o;
        return minTemperatureOutside == that.minTemperatureOutside;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minTemperatureOutside);
    }

    public int getMinTemperatureOutside() {
        return minTemperatureOutside;
    }

    public void setMinTemperatureOutside(int minTemperatureOutside) {
        this.minTemperatureOutside = minTemperatureOutside;
    }
}
