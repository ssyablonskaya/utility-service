package com.solvd.lesson8.organization.paper;

import com.solvd.lesson8.organization.staff.Director;

import java.time.LocalDateTime;

public class ReceiptOfPayment extends Document {

    public Director director;

    public ReceiptOfPayment(int number, String name, LocalDateTime dateOfPayment, Director director) {
        super(number, name, dateOfPayment);
        this.director = director;
    }

    @Override
    public String toString() {
        return "Name of the document: " + super.getName() + "; Date of payment: "
                + super.getDateOfPayment() + "; Signed by: " + director;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
