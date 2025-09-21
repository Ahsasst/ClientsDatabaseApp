package com.projects.ClientsDatabaseApp.service.mongo;

import com.projects.ClientsDatabaseApp.model.ClientMongo;
import com.projects.ClientsDatabaseApp.repository.ClientRepositoryMongo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceMongoImpl implements ClientServiceMongo {

    private final ClientRepositoryMongo clientRepositoryMongo;

    public ClientServiceMongoImpl(ClientRepositoryMongo clientRepositoryMongo) {
        this.clientRepositoryMongo = clientRepositoryMongo;
    }

    @Override
    public void createClient(ClientMongo client) {
        clientRepositoryMongo.save(client);
    }

    @Override
    public List<ClientMongo> getAllClients() {
        return clientRepositoryMongo.findAll();
    }

    @Override
    public ClientMongo getClientById(int id) {
        return clientRepositoryMongo.findById(id).orElse(null);
    }

    @Override
    public boolean updateClient(ClientMongo ClientMongo, int id) {
        if (clientRepositoryMongo.existsById(id)) {
            ClientMongo.setId(id);
            clientRepositoryMongo.save(ClientMongo);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteClient(int id) {
        if (clientRepositoryMongo.existsById(id)) {
            clientRepositoryMongo.deleteById(id);
            return true;
        }
        return false;
    }
}
