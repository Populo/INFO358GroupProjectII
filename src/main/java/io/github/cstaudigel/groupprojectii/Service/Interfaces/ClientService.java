package io.github.cstaudigel.groupprojectii.Service.Interfaces;

import io.github.cstaudigel.groupprojectii.Domain.Objects.Client;

public interface ClientService {

    /**
     * returns client from database by username
     *
     * @param username
     * @return
     */
    Client getClient(String username);

    /**
     * creates client in database
     *
     * @param c
     */
    void createClient(Client c);


    /**
     * modifies client in database
     *
     * probably will just delete old, add new unless UPDATE works as expected
     *
     * @param c
     */
    void modifyClient(Client c);



}
