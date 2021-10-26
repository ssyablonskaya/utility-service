package com.solvd.utilityservice.organization.service;

import com.solvd.utilityservice.organization.equipment.Utilizable;

/**
 * UtilizingStation utilizes unnecessary stuff in the special device
 */
public interface UtilizingStationService {

    void utilizeStuff(Utilizable utilizable);
}