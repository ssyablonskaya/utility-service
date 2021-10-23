package com.solvd.lesson8.organization.service.impl;

import com.solvd.lesson8.organization.service.AccountingService;
import com.solvd.lesson8.organization.staff.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;

public class AccountingServiceImpl implements AccountingService {

    public static final Logger LOGGER = LogManager.getLogger(AccountingServiceImpl.class);

    private List<Employee> employees;

    @Override
    public double salaryCounting(Employee employee) {
        double salary = 0;
        if (employee.getExperience() > 7) {
            salary = employee.getPosition().getSalary() * 1.4;
        } else if (employee.getExperience() > 3) {
            salary = employee.getPosition().getSalary() * 1.2;
        } else {
            salary = employee.getPosition().getSalary();
        }
        return salary;
    }

    @Override
    public void chargeBonus(Employee employee) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int monthOfBirth = employee.getDob().getMonthValue();
        double bonus = 0;
        if (month == monthOfBirth) {
            bonus = employee.getPosition().getSalary() + 100;
            LOGGER.debug(employee.getLastName() + "'s birthday bonus with salary this month is "
                    + bonus + " rubles.");
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}