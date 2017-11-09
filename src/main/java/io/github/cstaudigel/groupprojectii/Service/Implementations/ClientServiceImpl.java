package io.github.cstaudigel.groupprojectii.Service.Implementations;

import io.github.cstaudigel.groupprojectii.DAL.Interfaces.ClientDAO;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Client;
import io.github.cstaudigel.groupprojectii.Service.Interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }


    /**
     * returns client from database by username
     *
     * @param username
     * @return
     */
    @Override
    public Client getClient(String username) {
        return null;
    }

    /**
     * creates client in database
     *
     * @param c
     */
    @Override
    public void createClient(Client c) {

    }

    /**
     * modifies client in database
     * <p>
     * probably will just delete old, add new unless UPDATE works as expected
     *
     * @param c
     */
    @Override
    public void modifyClient(Client c) {

    }
}
