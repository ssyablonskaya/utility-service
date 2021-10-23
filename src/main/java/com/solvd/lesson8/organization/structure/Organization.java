package com.solvd.lesson8.organization.structure;

import com.solvd.lesson8.organization.service.Service;
import com.solvd.lesson8.organization.service.impl.AccountingServiceImpl;
import com.solvd.lesson8.organization.staff.Director;
import com.solvd.lesson8.organization.staff.Employee;

import java.util.List;
import java.util.Set;

public class Organization {

    private String name; //ZHES - Housing maintenance service №1
    private List<Director> directors;
    private Department department;
    private List<Employee> employees;
    private Set<Service> services;
    private AccountingServiceImpl accounting;

    public Organization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirector(List<Director> directors) {
        this.directors = directors;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployee(List<Employee> employees) {
        this.employees = employees;
    }

    public Set<Service> getService() {
        return services;
    }

    public void setService(Set<Service> service) {
        this.services = service;
    }

    public AccountingServiceImpl getAccounting() {
        return accounting;
    }

    public void setAccounting(AccountingServiceImpl accounting) {
        this.accounting = accounting;
    }
}
