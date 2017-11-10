package io.github.cstaudigel.groupprojectii.Service.Interfaces;

import io.github.cstaudigel.groupprojectii.Domain.Objects.Stylist;

/**
 * created by chris on 11/9/17
 */

public interface StylistService {

    /**
     * create a stylist in the db
     * @param s
     * @return
     */
    Stylist createStylist(Stylist s);

    /**
     * update a stylist in the db
     * @param s
     * @return
     */
    Stylist uptdateStylist(Stylist s);

    /**
     * return stylist from db by username
     *
     * @param username
     * @return
     */
    Stylist getStylistByUsername(String username);
}
