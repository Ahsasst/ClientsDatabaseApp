package com.projects.ClientsDatabaseApp.repository;

import com.projects.ClientsDatabaseApp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
