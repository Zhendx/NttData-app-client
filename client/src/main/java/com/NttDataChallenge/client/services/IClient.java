package com.NttDataChallenge.client.services;

import com.NttDataChallenge.client.dto.ClientRequestDTO;
import com.NttDataChallenge.client.dto.ClientResponseDTO;

import java.util.List;

public interface IClient {
    List<ClientResponseDTO> getAllClients();
    ClientResponseDTO getById(int id);
    ClientResponseDTO create(ClientRequestDTO personRequestDTO);
    ClientResponseDTO update(int id, ClientRequestDTO personRequestDTO);
    void deleteById(int id);
}
