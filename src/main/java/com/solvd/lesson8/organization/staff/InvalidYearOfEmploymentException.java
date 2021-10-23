package com.solvd.lesson8.organization.staff;

public class InvalidYearOfEmploymentException extends Exception {

    public InvalidYearOfEmploymentException(String message) {
        super(message);
    }

    public InvalidYearOfEmploymentException(String message, Throwable cause) {
        super(message, cause);
    }
}
