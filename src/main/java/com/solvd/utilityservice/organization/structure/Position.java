package com.solvd.utilityservice.organization.structure;

public class Position implements Comparable<Position> {

    private PositionName positionName;
    //private String name;
    private int salary;

    public Position(PositionName positionName, int salary) {
        this.positionName = positionName;
        this.salary = salary;
    }

    public void print() {
        System.out.println(positionName + ". Salary: " + salary + " rubles.");
    }

    @Override
    public String toString() {
        return "Position name: " + positionName +
                "; Salary = " + salary;
    }

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary <= 0) {
            throw new InvalidSalaryException("Salary is invalid.");
        }
        this.salary = salary;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }

    @Override
    public int compareTo(Position other) {
        return this.salary - other.salary;
    }
}
