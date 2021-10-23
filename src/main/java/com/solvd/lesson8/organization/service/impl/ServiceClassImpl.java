package com.solvd.lesson8.organization.service.impl;

import com.solvd.lesson8.organization.equipment.Utilizable;
import com.solvd.lesson8.organization.service.UtilizingStationService;
import com.solvd.lesson8.organization.staff.Payable;
import com.solvd.lesson8.organization.staff.Speakable;
import com.solvd.lesson8.organization.structure.Workable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceClassImpl implements UtilizingStationService {

    public static final Logger LOGGER = LogManager.getLogger(ServiceClassImpl.class);

    public void getSalary(Payable payable) {
        payable.decideToGetSalary();
        payable.goToAccounting();
        payable.sayYourName();
        payable.takeMoney(false);
        payable.sayGoodbye();
    }

    public void meetClient(Speakable speakable) {
        speakable.meetClient();
    }

    public void isDepartmentWork(Workable workable) {
        LOGGER.debug("Department is working now: " + workable.isNowWorkingHours());
    }

    @Override
    public void utilizeStuff(Utilizable utilizable) {
        utilizable.openUtilizingDevice();
        utilizable.dumpStuff();
        utilizable.push();
        utilizable.closeUtilizingDevice();
    }

}