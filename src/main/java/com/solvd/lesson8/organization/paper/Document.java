package com.solvd.lesson8.organization.paper;

import java.time.LocalDateTime;
import java.util.Objects;

public class Document {

    private Integer number;
    private String name;
    private LocalDateTime dateOfPayment;

    public Document(Integer number, String name, LocalDateTime dateOfPayment) {
        this.number = number;
        this.name = name;
        this.dateOfPayment = dateOfPayment;
    }

    public Document(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name of the document: " + name + "; Date of payment: " + dateOfPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return number == document.number && Objects.equals(name, document.name) && Objects.equals(dateOfPayment, document.dateOfPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, dateOfPayment);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDateTime dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
