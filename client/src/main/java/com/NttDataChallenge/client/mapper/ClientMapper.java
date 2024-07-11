package com.NttDataChallenge.client.mapper;

import com.NttDataChallenge.client.dto.ClientDTO;
import com.NttDataChallenge.client.dto.ClientRequestDTO;
import com.NttDataChallenge.client.dto.ClientResponseDTO;
import com.NttDataChallenge.client.models.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientRequestDTO clientDTOToClientRequestDTO(ClientDTO clientDTO);
    ClientEntity clientRequestToClient(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO clientToClientResponse(ClientEntity client);
    ClientRequestDTO clientToClientRequest(ClientEntity client);
    List<ClientResponseDTO> listClientToListClientResponse(List<ClientEntity> client);
}
