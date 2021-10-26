package com.solvd.utilityservice.organization.staff;

/**
 * Salary for the staff is on 15th day of the month.
 */
public interface Payable {

    void decideToGetSalary();

    void goToAccounting();

    void sayYourName();

    void takeMoney(boolean isIt15thToday);

    void sayGoodbye();

}
