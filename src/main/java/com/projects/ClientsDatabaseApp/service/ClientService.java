package com.projects.ClientsDatabaseApp.service;

import com.projects.ClientsDatabaseApp.model.Client;

import java.util.List;

public interface ClientService {

    /**
     * Create a new client
     *
     * @param client client to create
     */
    void createClient(Client client);

    /**
     * Return a list of all existing clients
     *
     * @return list of clients
     */
    List<Client> getAllClients();

    /**
     * Return the client by its ID
     *
     * @param id client's id
     * @return client
     */
    Client getClientById(int id);

    /**
     * Update the client with the given ID,
     * according to the client's transferred ID
     *
     * @param client the client according to which the data should be updated
     * @param id     client's id
     * @return true if the client has been updates, otherwise false
     */
    boolean updateClient(Client client, int id);

    /**
     * Delete the client with the given ID,
     * according to the client's transferred ID
     *
     * @param id client's id
     * @return true if the client has been deleted, otherwise false
     */
    boolean deleteClient(int id);
}
