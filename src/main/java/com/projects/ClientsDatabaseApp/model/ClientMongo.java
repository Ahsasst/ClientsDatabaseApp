package com.projects.ClientsDatabaseApp.model;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientMongo {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String phone;
}
