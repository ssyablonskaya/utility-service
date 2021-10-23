package com.solvd.lesson8.organization.equipment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Material implements Utilizable {

    public static final Logger LOGGER = LogManager.getLogger(Material.class);

    private String name;
    private int price;
    private int amount;

    public Material(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    /**
     * The Utilizable interface:
     */
    @Override
    public void openUtilizingDevice() {
        LOGGER.info("The utilizing device was opened.");
    }

    @Override
    public void dumpStuff() {
        LOGGER.debug(name + " was dumped to the device.");
    }

    @Override
    public void push() {
        LOGGER.info("The device was pushed.");
    }

    @Override
    public void closeUtilizingDevice() {
        LOGGER.info("Material was utilized. The device was closed.");
    }

    @Override
    public String toString() {
        return "Material: " + name + "; Price: " + price + " rubles; Amount: " + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return price == material.price && Objects.equals(name, material.name);
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
