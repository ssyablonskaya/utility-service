package com.solvd.utilityservice.organization.structure;

public class Position implements Comparable<Position> {

    private String name;
    private int salary;

    public Position(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void print() {
        System.out.println(name + ". Salary: " + salary + " rubles.");
    }

    @Override
    public String toString() {
        return "Position name: " + name +
                "; Salary = " + salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary <= 0) {
            throw new InvalidSalaryException("Salary is invalid.");
        }
        this.salary = salary;
    }

    @Override
    public int compareTo(Position other) {
        return this.salary - other.salary;
    }
}
