package io.github.cstaudigel.groupprojectii.DAL.Implementations;

import io.github.cstaudigel.groupprojectii.DAL.Interfaces.ClientDAO;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ClientDAOImpl implements ClientDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * returns client from db
     *
     * @param username
     * @return
     */
    @Override
    public Client getClientByUsername(String username) {
        String sql = "SELECT * FROM CLIENT WHERE C_USERNAME = ?";

        List<Client> clients = jdbcTemplate.query(sql, new Object[] {username},
                (rs, rowNum) -> (
                        new Client(
                                rs.getString("C_FIRSTNAME"),
                                rs.getString("C_LASTNAME"),
                                rs.getString("C_USERNAME"),
                                rs.getString("C_PASSWORD"))));

        if (!clients.isEmpty()) return clients.get(0);
        else return null;
    }

    /**
     * creates client in db
     *
     * @param c
     * @return
     */
    @Override
    public Client createClient(Client c) {

        String sql = "INSERT INTO CLIENT (S_FIRSTNAME, S_LASTNAME, S_USERNAME, S_PASSWORD) " +
                    "VALUES (?, ?, ?, ?);";

        jdbcTemplate.update(sql, new Object[]{c.getFirstname(), c.getLastname(), c.getUsername(), c.getPassword()});

        return c;
    }

    /**
     * updates client in db
     *
     * @param c
     * @return
     */
    @Override
    public Client updateClient(Client c) {

        deleteClient(c);

        createClient(c);

        return c;
    }

    /**
     * deletes client from db
     *
     * @param c
     * @return
     */
    @Override
    public Client deleteClient(Client c) {
        String delete = "DELETE FROM CLIENT WHERE C_USERNAME = ?";

        jdbcTemplate.update(delete, new Object[] {c.getUsername()});

        return c;
    }
}
