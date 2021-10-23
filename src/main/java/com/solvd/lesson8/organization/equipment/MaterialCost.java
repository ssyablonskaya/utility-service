package com.solvd.lesson8.organization.equipment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MaterialCost<E extends Material> {

    public static final Logger LOGGER = LogManager.getLogger(MaterialCost.class);

    private E item;

    public MaterialCost(E item) {
        this.item = item;
    }

    public int countCost() {
        return item.getPrice() * item.getAmount();
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

}