package com.projects.ClientsDatabaseApp.service.mongo;

import com.projects.ClientsDatabaseApp.model.ClientMongo;

import java.util.List;

public interface ClientServiceMongo {
    /**
     * Create a new client
     *
     * @param ClientMongo client to create
     */
    void createClient(ClientMongo ClientMongo);

    /**
     * Return a list of all existing clients
     *
     * @return list of clients
     */
    List<ClientMongo> getAllClients();

    /**
     * Return the client by its ID
     *
     * @param id client's id
     * @return client
     */
    ClientMongo getClientById(int id);

    /**
     * Update the client with the given ID,
     * according to the client's transferred ID
     *
     * @param ClientMongo the client according to which the data should be updated
     * @param id     client's id
     * @return true if the client has been updates, otherwise false
     */
    boolean updateClient(ClientMongo ClientMongo, int id);

    /**
     * Delete the client with the given ID,
     * according to the client's transferred ID
     *
     * @param id client's id
     * @return true if the client has been deleted, otherwise false
     */
    boolean deleteClient(int id);
}
