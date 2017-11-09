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
     * @return Client
     */
    @Override
    public Client getClient(String username) {
        return clientDAO.getClient(username);
    }

    /**
     * creates client in database
     *
     * @param c
     * @return Client
     */
    @Override
    public Client createClient(Client c) {
        return clientDAO.createClient(c);
    }

    /**
     * modifies client in database
     * <p>
     * probably will just delete old, add new unless UPDATE works as expected
     *
     * @param c
     * @return Client
     */
    @Override
    public Client modifyClient(Client c) {
        return clientDAO.updateClient(c);
    }
}
