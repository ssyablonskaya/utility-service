package com.solvd.lesson8.organization.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Service {

    public static final Logger LOGGER = LogManager.getLogger(Service.class);

    private String name;
    private int price;
    private int doTime;
    private boolean canZhesDoJob;
    private boolean isInZhirovka;

    public Service(String name, int price, int doTime) {
        this.name = name;
        this.price = price;
        this.doTime = doTime;
    }

    public Service(String name, int price, int doTime, boolean canZhesDoJob, boolean isInZhirovka) {
        this.name = name;
        this.price = price;
        this.doTime = doTime;
        this.canZhesDoJob = canZhesDoJob;
        this.isInZhirovka = isInZhirovka;
    }

    public void doService(Service service, double givenMoney) {
        if (givenMoney >= service.getPrice()) {
            LOGGER.info("Thank you. The service will be done.");
        } else {
            LOGGER.info("Sorry. The amount of money isn't enough.");
        }
    }

    public void doService(Service service) {
        LOGGER.info("Please, pay for the service.");
    }

    @Override
    public String toString() {
        return "Name: " + name + "; Price: " + price + " rubles; Time to do: " + doTime + " hours.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return price == service.price && Objects.equals(name, service.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDoTime() {
        return doTime;
    }

    public void setDoTime(int doTime) {
        this.doTime = doTime;
    }

    public boolean isCanZhesDoJob() {
        return canZhesDoJob;
    }

    public void setCanZhesDoJob(boolean canZhesDoJob) {
        this.canZhesDoJob = canZhesDoJob;
    }

    public boolean isInZhirovka() {
        return isInZhirovka;
    }

    public void setInZhirovka(boolean inZhirovka) {
        isInZhirovka = inZhirovka;
    }
}
