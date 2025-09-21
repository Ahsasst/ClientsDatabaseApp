package com.projects.ClientsDatabaseApp.service.postgres;

import com.projects.ClientsDatabaseApp.model.ClientPostgres;
import com.projects.ClientsDatabaseApp.repository.ClientRepositoryPostgres;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServicePostgresImpl implements ClientServicePostgres {

    private final ClientRepositoryPostgres clientRepositoryPostgres;

    public ClientServicePostgresImpl(ClientRepositoryPostgres clientRepositoryPostgres) {
        this.clientRepositoryPostgres = clientRepositoryPostgres;
    }

    @Override
    public void createClient(ClientPostgres clientPostgres) {
        clientRepositoryPostgres.save(clientPostgres);
    }

    @Override
    public List<ClientPostgres> getAllClients() {
        return clientRepositoryPostgres.findAll();
    }

    @Override
    public ClientPostgres getClientById(int id) {
        return clientRepositoryPostgres.findById(id).orElse(null);
    }

    @Override
    public boolean updateClient(ClientPostgres clientPostgres, int id) {
        if (clientRepositoryPostgres.existsById(id)) {
            clientPostgres.setId(id);
            clientRepositoryPostgres.save(clientPostgres);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteClient(int id) {
        if (clientRepositoryPostgres.existsById(id)) {
            clientRepositoryPostgres.deleteById(id);
            return true;
        }
        return false;
    }
}
