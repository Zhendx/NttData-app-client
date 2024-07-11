package com.NttDataChallenge.client.models.entity;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
public class PersonEntity {

    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;
}
