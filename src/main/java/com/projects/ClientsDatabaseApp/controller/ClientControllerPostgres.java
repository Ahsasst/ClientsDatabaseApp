package com.projects.ClientsDatabaseApp.controller;

import com.projects.ClientsDatabaseApp.model.ClientPostgres;
import com.projects.ClientsDatabaseApp.service.postgres.ClientServicePostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postgres/clients")
public class ClientControllerPostgres {

    private final ClientServicePostgres clientServicePostgres;

    @Autowired
    public ClientControllerPostgres(ClientServicePostgres clientServicePostgres) {
        this.clientServicePostgres = clientServicePostgres;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClientPostgres clientPostgres) {
        clientServicePostgres.createClient(clientPostgres);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClientPostgres>> read() {
        final List<ClientPostgres> clientPostgres = clientServicePostgres.getAllClients();

        return clientPostgres != null && !clientPostgres.isEmpty()
                ? new ResponseEntity<>(clientPostgres, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientPostgres> read(@PathVariable(name = "id") int id) {
        final ClientPostgres clientPostgres = clientServicePostgres.getClientById(id);

        return clientPostgres != null
                ? new ResponseEntity<>(clientPostgres, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody ClientPostgres clientPostgres) {
        final boolean updated = clientServicePostgres.updateClient(clientPostgres, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = clientServicePostgres.deleteClient(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}