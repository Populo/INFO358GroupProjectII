package io.github.cstaudigel.groupprojectii.DAL.Interfaces;

import io.github.cstaudigel.groupprojectii.Domain.Objects.Client;

public interface ClientDAO {

    /**
     * returns client from db
     *
     * @param username
     * @return
     */
    Client getClientByUsername(String username);


    /**
     * creates client in db
     *
     * @param c
     * @return
     */
    Client createClient(Client c);

    /**
     * updates client in db
     *
     * @param c
     * @return
     */
    Client updateClient(Client c);

    /**
     * deletes client from db
     *
     * @param c
     * @return
     */
    Client deleteClient(Client c);
}
