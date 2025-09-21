package com.projects.ClientsDatabaseApp.repository;

import com.projects.ClientsDatabaseApp.model.ClientMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepositoryMongo extends MongoRepository<ClientMongo, Integer> {
}
