package com.solvd.utilityservice.organization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

/**
 * Printing a catalog of any collection from the organization
 */
public class OrgCatalog<E> {

    public static final Logger LOGGER = LogManager.getLogger(OrgCatalog.class);

    private Collection<E> catalogs;

    public void printCatalog(Collection<E> catalogs) {
        catalogs.forEach(item -> LOGGER.debug(item));

    }

    public Collection<E> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(Collection<E> catalogs) {
        this.catalogs = catalogs;
    }
}
