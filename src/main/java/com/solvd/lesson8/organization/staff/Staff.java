package com.solvd.lesson8.organization.staff;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Staff implements Speakable, Payable {

    public static final Logger LOGGER = LogManager.getLogger(Staff.class);

    private String firstName;
    private String lastName;
    private int yearOfEmployment;

    public Staff(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public void takeMoney(boolean isIt15thToday) {
        if (isIt15thToday) {
            LOGGER.debug("Yes, " + firstName + ". Please, here your money!");
        } else {
            LOGGER.info("Sorry, salary will be on the 15th.");
        }
    }

    public void countYearsOfWork(int yearOfEmployment) {
        LocalDateTime dateNow = LocalDateTime.now();
        int years = dateNow.getYear() - yearOfEmployment;
        LOGGER.debug(firstName + " " + lastName + " is working in the organization for " + years + " years.");
    }

    /**
     * The Speakable interface:
     */
    public abstract void meetClient();

    @Override
    public String toString() {
        return "First name: " + firstName + "; Last name: " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return yearOfEmployment == staff.yearOfEmployment && firstName.equals(staff.firstName) && lastName.equals(staff.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, yearOfEmployment);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.equals("")) {
            throw new InvalidNameException("User name is invalid");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.equals("")) {
            throw new InvalidNameException("User name is invalid");
        }
        this.lastName = lastName;
    }

    public int getYearOfEmployment() {
        return yearOfEmployment;
    }

    public void setYearOfEmployment(int yearOfEmployment) throws InvalidYearOfEmploymentException {
        if (yearOfEmployment < 2006) {
            throw new InvalidYearOfEmploymentException("Incorrect year of employment. The organization was founded in 2006.");
        }
        this.yearOfEmployment = yearOfEmployment;

    }
}
