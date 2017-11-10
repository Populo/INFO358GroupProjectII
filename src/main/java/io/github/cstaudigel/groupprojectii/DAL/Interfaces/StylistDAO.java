package io.github.cstaudigel.groupprojectii.DAL.Interfaces;

import io.github.cstaudigel.groupprojectii.Domain.Objects.Stylist;

/**
 * created by chris on 11/9/17
 */

public interface StylistDAO {

    /**
     * create stylist in the db
     * @param s
     * @return
     */
    Stylist createStylist(Stylist s);

    /**
     * update stylist in db
     * @param s
     * @return
     */
    Stylist updateStylist(Stylist s);

    /**
     * return stylist from db by username
     * @param username
     * @return
     */
    Stylist getStylistByUsername(String username);

    /**
     * delete stylist from db
     * @param s
     * @return
     */
    Stylist deleteStylist(Stylist s);
}
