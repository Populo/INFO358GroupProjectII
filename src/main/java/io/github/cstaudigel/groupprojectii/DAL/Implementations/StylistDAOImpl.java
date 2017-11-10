package io.github.cstaudigel.groupprojectii.DAL.Implementations;

import io.github.cstaudigel.groupprojectii.DAL.Interfaces.StylistDAO;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Stylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * created by chris on 11/9/17
 */


public class StylistDAOImpl implements StylistDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * create stylist in the db
     *
     * @param s
     * @return
     */
    @Override
    public Stylist createStylist(Stylist s) {
        String sql = "INSERT INTO STYLIST (S_FIRSTNAME, S_LASTNAME, S_USERNAME, S_PASSWORD)" +
                    "VALUES (?, ?, ?, ?);";

        jdbcTemplate.update(sql, new Object[]{s.getFirstname(), s.getLastname(), s.getUsername(), s.getPassword()});

        return s;
    }

    /**
     * update stylist in db
     *
     * @param s
     * @return
     */
    @Override
    public Stylist updateStylist(Stylist s) {
        deleteStylist(s);

        createStylist(s);

        return s;
    }

    /**
     * return stylist from db by username
     *
     * @param username
     * @return
     */
    @Override
    public Stylist getStylistByUsername(String username) {
        String sql = "SELECT * FROM STYLIST WHERE S_USERNAME = ?";

        List<Stylist> stylists = jdbcTemplate.query(sql, new Object[] {username},
                (rs, rowNum) -> (
                        new Stylist(
                                rs.getString("S_FIRSTNAME"),
                                rs.getString("S_LASTNAME"),
                                rs.getString("S_USERNAME"),
                                rs.getString(("S_PASSWORD")))));

        if (!stylists.isEmpty()) return stylists.get(0);
        else return null;
    }

    /**
     * delete stylist from db
     *
     * @param s
     * @return
     */
    @Override
    public Stylist deleteStylist(Stylist s) {
        String sql = "DELETE FROM STYLIST WHERE S_USERNAME = ?";

        jdbcTemplate.update(sql, new Object[] {s.getUsername()});

        return s;
    }
}
