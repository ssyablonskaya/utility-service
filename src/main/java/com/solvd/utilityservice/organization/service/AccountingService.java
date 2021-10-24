package com.solvd.utilityservice.organization.service;

import com.solvd.utilityservice.organization.staff.Employee;

public interface AccountingService {

    double salaryCounting(Employee employee);

    void chargeBonus(Employee employee);

}
