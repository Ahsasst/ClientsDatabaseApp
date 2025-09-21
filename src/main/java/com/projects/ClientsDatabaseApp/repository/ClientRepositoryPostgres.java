package com.projects.ClientsDatabaseApp.repository;

import com.projects.ClientsDatabaseApp.model.ClientPostgres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoryPostgres extends JpaRepository<ClientPostgres, Integer>{
}
