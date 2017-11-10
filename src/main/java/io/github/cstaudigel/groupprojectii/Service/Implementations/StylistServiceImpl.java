package io.github.cstaudigel.groupprojectii.Service.Implementations;

import io.github.cstaudigel.groupprojectii.DAL.Interfaces.StylistDAO;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Stylist;
import io.github.cstaudigel.groupprojectii.Service.Interfaces.StylistService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by chris on 11/9/17
 */


public class StylistServiceImpl implements StylistService {

    @Autowired
    private StylistDAO stylistDAO;

    @Autowired
    public StylistServiceImpl(StylistDAO stylistDAO) {
        this.stylistDAO = stylistDAO;
    }

    /**
     * create a stylist in the db
     *
     * @param s
     * @return
     */
    @Override
    public Stylist createStylist(Stylist s) {
        Stylist tempStylist = getStylistByUsername(s.getUsername());

        if (tempStylist == null) return stylistDAO.createStylist(s);
        else return null;
    }

    /**
     * update a stylist in the db
     *
     * @param s
     * @return
     */
    @Override
    public Stylist uptdateStylist(Stylist s) {
        return stylistDAO.updateStylist(s);
    }

    /**
     * return stylist from db by username
     *
     * @param username
     * @return
     */
    @Override
    public Stylist getStylistByUsername(String username) {
        return stylistDAO.getStylistByUsername(username);
    }
}
