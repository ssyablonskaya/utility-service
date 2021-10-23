package com.solvd.lesson8.organization.structure;

public class InvalidSalaryException extends RuntimeException {

    public InvalidSalaryException(String message) {
        super(message);
    }

    public InvalidSalaryException(String message, Throwable cause) {
        super(message, cause);
    }
}
