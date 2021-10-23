package com.solvd.lesson8;

import com.solvd.lesson8.organization.service.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class BusinessQuestion {

    public static final Logger LOGGER = LogManager.getLogger(BusinessQuestion.class);

    private Set<Service> services;

    public void print(Set<Service> services) {
        LOGGER.info("Business-question:");
        for (Service element : services) {
            System.out.println();
            LOGGER.debug("Zhes can do " + element.getName() + ": " + element.isCanZhesDoJob() + ".");
            LOGGER.debug("This service is in zhirovka: " + element.isInZhirovka() + ".");
            LOGGER.debug(element.getName() + " will cost " + element.getPrice() + " rubles. ");
            LOGGER.debug("Job will be done in " + element.getDoTime() + " hours. ");
        }

    }

    public Set<Service> getServices() {
        return services;
    }

    public void setService(Set<Service> services) {
        this.services = services;
    }
}
