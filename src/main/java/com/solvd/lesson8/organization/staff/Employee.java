package com.solvd.lesson8.organization.staff;

import com.solvd.lesson8.organization.structure.Position;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Objects;

public class Employee extends Staff implements Speakable, Payable {

    public static final Logger LOGGER = LogManager.getLogger(Employee.class);

    public static int countEmployees = 0;

    private LocalDateTime dob;
    private Position position;
    private double salary;
    private int experience;

    public Employee(String firstName, String lastName, Position position) {
        super(firstName, lastName);
        this.position = position;
        countEmployees++;
    }

    /**
     * The Speakable interface:
     */
    @Override
    public void meetClient() {
        LOGGER.debug("Hello, my name is " + super.getFirstName() + " " + super.getLastName() + ". How can I help you?");
    }

    /**
     * The Payable interface:
     */
    @Override
    public void decideToGetSalary() {
        LOGGER.info("Thoughts: Hmm, maybe it's time to get salary!");
    }

    @Override
    public void goToAccounting() {
        LOGGER.info("Employee has come to the accounting.");
    }

    @Override
    public void sayYourName() {
        LOGGER.debug("Hello, my name is " + super.getFirstName() + " " + super.getLastName() + ". Can I get my salary?");
    }

    @Override
    public void takeMoney(boolean isIt15thToday) {
        if (isIt15thToday) {
            LOGGER.debug("Yes, " + super.getFirstName() + ". Please, here your money!");
        } else {
            LOGGER.info("Sorry, salary will be on the 15th.");
        }
    }

    @Override
    public void sayGoodbye() {
        LOGGER.info("Thanks. Goodbye!");
    }

    public static void ask() {
        LOGGER.info("Hello. How can I help you?");
    }

    public void chooseBonusForEmployee(Employee employee, int bonusForLoyalty) {
        LOGGER.debug(bonusForLoyalty + " rubles will be given to " + super.getFirstName() + " ASAP.");
    }

    public void chooseBonusForEmployee(Employee employee) {
        LOGGER.info("You should choose the amount of the bonus.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(dob, employee.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dob);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getSalary() {
        return position.getSalary();
    }

    public void setSalary(double salary) {
        this.salary = position.getSalary();
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalDateTime getDob() {
        return dob;
    }

}
