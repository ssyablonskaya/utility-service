package com.solvd.utilityservice.organization.structure;

import com.solvd.utilityservice.organization.staff.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

//profsouz - trade-union committee
public class Profsouz extends Department implements Workable {

    public static final Logger LOGGER = LogManager.getLogger(Profsouz.class);

    private LocalDateTime foundation;
    private String head;

    public Profsouz(String name) {
        super(name);
    }

    public Profsouz(String name, String head, int amountEmployees) {
        super(name, amountEmployees);
        this.head = head;
    }

    /**
     * The Workable interface:
     * Is Profsouz working now?
     */
    @Override
    public boolean isNowWorkingHours() {
        LocalDateTime nowTime = LocalDateTime.now();
        return nowTime.getHour() >= 6 && nowTime.getHour() <= 17;
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + "; Head of dep: " + head
                + "; Amount of employees: " + super.getAmountEmployees() + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Profsouz profsouz = (Profsouz) o;
        return Objects.equals(head, profsouz.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), head);
    }

    public void sayHB(Employee employee) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int monthOfBirth = employee.getDob().getMonthValue();
        int day = date.getDayOfMonth();
        int dayOfBirth = employee.getDob().getDayOfMonth();
        if (month == monthOfBirth && day == dayOfBirth) {
            LOGGER.debug("Trade-union committee wishes you all the best! Happy Birthday, "
                    + employee.getFirstName() + " " + employee.getLastName() + "!");
        }
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public LocalDateTime getFoundation() {
        return foundation;
    }

    public void setFoundation(LocalDateTime foundation) {
        this.foundation = foundation;
    }
}
