package com.NttDataChallenge.client.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="client")
@Getter
@Setter
public class ClientEntity extends PersonEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int idClient;

    private String password;
    private Boolean state;
}
