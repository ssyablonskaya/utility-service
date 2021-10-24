package com.solvd.utilityservice.organization.equipment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConstructionMaterial extends Material {

    public static final Logger LOGGER = LogManager.getLogger(ConstructionMaterial.class);

    private boolean isUsingNow;

    public ConstructionMaterial(String name, int price, int amount, boolean isUsingNow) {
        super(name, price, amount);
        this.isUsingNow = isUsingNow;
    }

    @Override
    public void closeUtilizingDevice() {
        LOGGER.info("Construction material was utilized. The device was closed.");
    }

    @Override
    public String toString() {
        return "Construction material: " + super.getName() + "; Price: " + super.getPrice()
                + " rubles; Amount: " + super.getAmount() + "; Now is in progress: " + isUsingNow;
    }

    public boolean getIsUsingNow() {
        return isUsingNow;
    }

    public void setIsUsingNow(boolean isUsingNow) {
        this.isUsingNow = isUsingNow;
    }
}
