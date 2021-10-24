package com.solvd.utilityservice.organization.staff;

/**
 * If firstName and lastName are invalid
 */
public class InvalidNameException extends RuntimeException {

    public InvalidNameException(String message) {
        super(message);
    }

    public InvalidNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
