package com.projects.ClientsDatabaseApp.service.postgres;

import com.projects.ClientsDatabaseApp.model.ClientPostgres;

import java.util.List;

public interface ClientServicePostgres {

    /**
     * Create a new client
     *
     * @param clientPostgres client to create
     */
    void createClient(ClientPostgres clientPostgres);

    /**
     * Return a list of all existing clients
     *
     * @return list of clients
     */
    List<ClientPostgres> getAllClients();

    /**
     * Return the client by its ID
     *
     * @param id client's id
     * @return client
     */
    ClientPostgres getClientById(int id);

    /**
     * Update the client with the given ID,
     * according to the client's transferred ID
     *
     * @param clientPostgres the client according to which the data should be updated
     * @param id     client's id
     * @return true if the client has been updates, otherwise false
     */
    boolean updateClient(ClientPostgres clientPostgres, int id);

    /**
     * Delete the client with the given ID,
     * according to the client's transferred ID
     *
     * @param id client's id
     * @return true if the client has been deleted, otherwise false
     */
    boolean deleteClient(int id);
}
