package com.solvd.lesson8.organization.service;

import com.solvd.lesson8.organization.staff.Employee;

public interface AccountingService {

    double salaryCounting(Employee employee);

    void chargeBonus(Employee employee);

}
