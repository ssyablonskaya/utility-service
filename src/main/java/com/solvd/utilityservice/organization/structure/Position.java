package com.solvd.utilityservice.organization.structure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Position implements Comparable<Position> {

    public static final Logger LOGGER = LogManager.getLogger(Position.class);

    private PositionName positionName;
    private int salary;

    public Position(PositionName positionName, int salary) {
        this.positionName = positionName;
        this.salary = salary;
    }

    public void print() {
        System.out.println(positionName + ". Salary: " + salary + " rubles.");
    }

    public void doGoodWork() {
        if (PositionName.ACCOUNTANT.equals(positionName)) {
            LOGGER.info("You're doing pretty good brain work. Go ahead!");
        } else {
            LOGGER.info("You're doing pretty good physical work. Go ahead!");
        }
    }

    @Override
    public String toString() {
        return "Position name: " + positionName +
                "; Salary = " + salary;
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
