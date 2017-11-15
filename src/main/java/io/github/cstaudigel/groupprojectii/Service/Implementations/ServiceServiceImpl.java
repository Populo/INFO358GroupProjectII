package io.github.cstaudigel.groupprojectii.Service.Implementations;

import io.github.cstaudigel.groupprojectii.DAL.Interfaces.ServiceDAO;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Service;
import io.github.cstaudigel.groupprojectii.Service.Interfaces.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * created by chris on 11/14/17
 */


@Component
public class ServiceServiceImpl implements ServiceService {

    private ServiceDAO serviceDAO;

    @Autowired
    public ServiceServiceImpl(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    /**
     * returns service by code
     *
     * @param code
     * @return
     */
    @Override
    public Service getServiceByCode(int code) {
        return serviceDAO.getServiceByCode(code);
    }

    /**
     * updates service in database
     *
     * @param newService
     * @return
     */
    @Override
    public Service modifyService(Service newService) {
        return serviceDAO.modifyService(newService);
    }

    /**
     * removes service from database
     *
     * @param s
     * @return
     */
    @Override
    public Service removeService(Service s) {
        return serviceDAO.removeService(s);
    }

    /**
     * creates service in database
     *
     * @param s
     * @return
     */
    @Override
    public Service createService(Service s) {
        if (this.getServiceByCode(s.getID()) == null) {
            return serviceDAO.createService(s);
        }
        else return null;
    }

    public Service createService(int id, String name, int time, double cost) {
        return this.createService(new Service(id, name, time, cost));
    }
}
