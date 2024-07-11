package com.NttDataChallenge.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ClientResponseDTO implements Serializable {

    private int idClient;
    private String password;
    private Boolean state;
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;
}
