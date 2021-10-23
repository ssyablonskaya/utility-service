package com.solvd.lesson8.organization.service;

import com.solvd.lesson8.organization.equipment.Utilizable;

/**
 * UtilizingStation utilizes unnecessary stuff in the special device
 */
public interface UtilizingStationService {

    void utilizeStuff(Utilizable utilizable);
}