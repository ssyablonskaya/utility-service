package com.solvd.utilityservice;

import com.solvd.utilityservice.organization.service.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class BusinessQuestion {

    public static final Logger LOGGER = LogManager.getLogger(BusinessQuestion.class);

    private Set<Service> services;

    public void print(Set<Service> services) {
        LOGGER.info("Business-question:");
        services.stream()
                .forEach(element -> LOGGER.debug("\nZhes can do " + element.getName() + ": " + element.isCanZhesDoJob()
                        + ".\nThis service is in zhirovka: " + element.isInZhirovka() + ".\n"
                        + element.getName() + " will cost " + element.getPrice() + " rubles."
                        + "\nJob will be done in " + element.getDoTime() + " hours."));

    }

    public Set<Service> getServices() {
        return services;
    }

    public void setService(Set<Service> services) {
        this.services = services;
    }
}
