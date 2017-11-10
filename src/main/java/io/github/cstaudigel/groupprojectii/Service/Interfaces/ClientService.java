package io.github.cstaudigel.groupprojectii.Service.Interfaces;

import io.github.cstaudigel.groupprojectii.Domain.Objects.Client;

public interface ClientService {

    /**
     * returns client from database by username
     *
     * @param username
     * @return Client
     */
    Client getClientByUsername(String username);

    /**
     * creates client in database
     *
     * @param c
     * @return Client
     */
    Client createClient(Client c);


    /**
     * modifies client in database
     *
     * probably will just delete old, add new unless UPDATE works as expected
     *
     * @param c
     * @return Client
     */
    Client modifyClient(Client c);



}
