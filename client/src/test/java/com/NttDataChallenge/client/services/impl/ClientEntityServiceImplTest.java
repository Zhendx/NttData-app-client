package com.NttDataChallenge.client.services.impl;

import com.NttDataChallenge.client.repository.ClientRepository;
import com.NttDataChallenge.client.util.MockUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClientEntityServiceImplTest {
    @InjectMocks
    ClientServiceImpl clientService;
    @Mock
    private ClientRepository clientRep;

    @Test
    void getAllClients() {
        Mockito.when(clientRep.findAll())
                .thenReturn(MockUtil.buildListClient());
        assertNotNull(clientService.getAllClients());
        Mockito.verify(clientRep).findAll();
    }

    @Test
    void getById() {
        Mockito.when(clientRep.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(MockUtil.buildClient()));
        Assertions.assertNotNull(clientService.getById(1));
        Mockito.verify(clientRep).findById(Mockito.anyInt());
    }

    @Test
    void create() {
        Mockito.when(clientRep.save(Mockito.any()))
                .thenReturn(MockUtil.buildClient());
        //Assertions.assertNotNull(clientService.create(MockUtil.buildClientReq()));
        Mockito.verify(clientRep).save(Mockito.any());
    }

    @Test
    void update() {
        Mockito.when(clientRep.findById(Mockito.any()))
                .thenReturn(Optional.of(MockUtil.buildClient()));
        Mockito.when(clientRep.save(Mockito.any()))
                .thenReturn(MockUtil.buildClient());
        Assertions.assertNotNull(clientService.update( 1 ,MockUtil.buildClientReq()));
    }

    @Test
    void deleteById() {
        Mockito.when(clientRep.findById(Mockito.anyInt()))
                .thenReturn(null);
    }
}