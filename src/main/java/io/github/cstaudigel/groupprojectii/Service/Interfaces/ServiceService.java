package io.github.cstaudigel.groupprojectii.Service.Interfaces;

import io.github.cstaudigel.groupprojectii.Domain.Objects.Service;

/**
 * created by chris on 11/14/17
 */


public interface ServiceService {

    /**
     * returns service by code
     * @param code
     * @return
     */
    Service getServiceByCode(String code);
}
