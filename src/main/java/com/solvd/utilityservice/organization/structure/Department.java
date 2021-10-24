package com.solvd.utilityservice.organization.structure;

import java.util.Objects;

public abstract class Department implements Workable {

    private String name;
    private int employeesAmount;

    public Department(String name) {
        this.name = name;
        employeesAmount = 1;
    }

    public Department(String name, int employeesAmount) {
        this.name = name;
        this.employeesAmount = employeesAmount;
    }

    public abstract boolean isNowWorkingHours();

    @Override
    public String toString() {
        return "Dep's name: " + name + "; Amount of employees: " + employeesAmount + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountEmployees() {
        return employeesAmount;
    }

    public void setAmountEmployees(int amountEmployees) {
        this.employeesAmount = amountEmployees;
    }
}
