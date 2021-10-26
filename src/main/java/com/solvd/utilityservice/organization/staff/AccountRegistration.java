package com.solvd.utilityservice.organization.staff;

/**
 * @param <E> - employee's password to create their personal account at work
 */
public class AccountRegistration<E> {

    private E password;

    public AccountRegistration(E password) {
        this.password = password;
    }

    public E getPassword() {
        return password;
    }

    public void setPassword(E password) {
        this.password = password;
    }

}
