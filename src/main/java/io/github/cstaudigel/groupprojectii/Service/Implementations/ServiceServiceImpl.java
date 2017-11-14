package io.github.cstaudigel.groupprojectii.Service.Implementations;

import io.github.cstaudigel.groupprojectii.Domain.Objects.Service;
import io.github.cstaudigel.groupprojectii.Service.Interfaces.ServiceService;
import org.springframework.stereotype.Component;

/**
 * created by chris on 11/14/17
 */


@Component
public class ServiceServiceImpl implements ServiceService {


    /**
     * returns service by code
     *
     * @param code
     * @return
     */
    @Override
    public Service getServiceByCode(String code) {
        return null;
    }
}
