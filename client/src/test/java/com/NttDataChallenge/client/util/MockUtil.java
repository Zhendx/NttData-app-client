package com.NttDataChallenge.client.util;

import com.NttDataChallenge.client.dto.ClientRequestDTO;
import com.NttDataChallenge.client.models.entity.ClientEntity;

import java.util.ArrayList;
import java.util.List;

public class MockUtil {

    public static List<ClientEntity> buildListClient(){
        List<ClientEntity> listPerson = new ArrayList<>();
        listPerson.add(buildClient());
        return listPerson;
    }
    public static ClientEntity buildClient(){
        ClientEntity client = new ClientEntity();
        client.setIdClient(1);
        client.setPassword("123456");
        client.setState(true);
        client.setName("a");
        client.setGender("Masculino");
        client.setAge(20);
        client.setIdentification("0706587425");
        client.setAddress("Avenida");
        client.setPhone("0729854685");
        return client;
    }
    public static ClientRequestDTO buildClientReq(){
        ClientRequestDTO personReq = new ClientRequestDTO();
        personReq.setIdClient(1);
        personReq.setPassword("123456");
        personReq.setState(true);
        personReq.setName("a");
        personReq.setGender("Masculino");
        personReq.setAge(20);
        personReq.setIdentification("0706587425");
        personReq.setAddress("Avenida");
        personReq.setPhone("0729854685");
        return personReq;
    }
}
