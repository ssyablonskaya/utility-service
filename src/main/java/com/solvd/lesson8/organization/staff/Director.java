package com.solvd.lesson8.organization.staff;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Director extends Staff implements Speakable, Payable {

    public static final Logger LOGGER = LogManager.getLogger(Director.class);

    public Director(String firstName, String lastName) {
        super(firstName, lastName);
    }

    /**
     * The Speakable interface:
     */
    @Override
    public void meetClient() {
        LOGGER.debug("Hello, I'm " + super.getFirstName() + " " + super.getLastName()
                + ", the director of this organization. How can we solve your problems?");
    }

    /**
     * The Payable interface:
     */
    @Override
    public void decideToGetSalary() {
        LOGGER.info("Thoughts: Hope our organization has money for directors, time to get salary!");
    }

    @Override
    public void goToAccounting() {
        LOGGER.info("The director has come to the accounting.");
    }

    @Override
    public void sayYourName() {
        LOGGER.debug("Hello, my name is " + super.getFirstName() + " "
                + super.getLastName() + ". Can I get my salary?");
    }

    @Override
    public void takeMoney(boolean isIt15thToday) {
        if (isIt15thToday) {
            LOGGER.debug("Yes, Mr. " + super.getLastName() + ". Please, here your money!");
        } else {
            LOGGER.info("Sorry, salary will be on the 15th.");
        }
    }

    @Override
    public void sayGoodbye() {
        LOGGER.info("Thanks. Goodbye!");
    }

}
