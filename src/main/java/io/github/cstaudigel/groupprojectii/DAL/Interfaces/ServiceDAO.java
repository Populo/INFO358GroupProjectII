package io.github.cstaudigel.groupprojectii.DAL.Interfaces;

import io.github.cstaudigel.groupprojectii.Domain.Objects.Service;

/**
 * created by chris on 11/14/17
 */


public interface ServiceDAO {

    /**
     * create service in database
     * @param s
     * @return
     */
    Service createService(Service s);

    /**
     * update service in database
     * @param newService
     * @return
     */
    Service modifyService(Service newService);

    /**
     * remove service from database
     * @param s
     * @return
     */
    Service removeService(Service s);

    /**
     * return service from database by code
     * @param code
     * @return
     */
    Service getServiceByCode(int code);
}
