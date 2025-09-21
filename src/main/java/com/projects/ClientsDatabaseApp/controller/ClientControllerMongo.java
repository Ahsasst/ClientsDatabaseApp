package com.projects.ClientsDatabaseApp.controller;

import com.projects.ClientsDatabaseApp.model.ClientMongo;
import com.projects.ClientsDatabaseApp.service.mongo.ClientServiceMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo/clients")
public class ClientControllerMongo {

    private final ClientServiceMongo ClientServiceMongo;

    @Autowired
    public ClientControllerMongo(ClientServiceMongo ClientServiceMongo) {
        this.ClientServiceMongo = ClientServiceMongo;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClientMongo ClientMongo) {
        ClientServiceMongo.createClient(ClientMongo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClientMongo>> read() {
        final List<ClientMongo> ClientMongo = ClientServiceMongo.getAllClients();

        return ClientMongo != null && !ClientMongo.isEmpty()
                ? new ResponseEntity<>(ClientMongo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientMongo> read(@PathVariable(name = "id") int id) {
        final ClientMongo ClientMongo = ClientServiceMongo.getClientById(id);

        return ClientMongo != null
                ? new ResponseEntity<>(ClientMongo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody ClientMongo ClientMongo) {
        final boolean updated = ClientServiceMongo.updateClient(ClientMongo, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = ClientServiceMongo.deleteClient(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
