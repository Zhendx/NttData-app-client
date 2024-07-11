package com.NttDataChallenge.client.services.impl;

import com.NttDataChallenge.client.dto.ClientRequestDTO;
import com.NttDataChallenge.client.dto.ClientResponseDTO;
import com.NttDataChallenge.client.exception.AppException;
import com.NttDataChallenge.client.exception.ConstantError;
import com.NttDataChallenge.client.json.IDecodeJSON;
import com.NttDataChallenge.client.mapper.ClientMapper;
import com.NttDataChallenge.client.models.entity.ClientEntity;
import com.NttDataChallenge.client.repository.ClientRepository;
import com.NttDataChallenge.client.services.IClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClient {
    private final IDecodeJSON clientDecode;
    private final ClientRepository clientRep;
    private final RedisTemplate template;
    private final ChannelTopic topic;
    @Override
    public List<ClientResponseDTO> getAllClients(){
        return ClientMapper.INSTANCE.listClientToListClientResponse(clientRep.findAll());
    };
    @Override
    public ClientResponseDTO getById(int id){
        ClientEntity client = clientRep.findById(id).orElseThrow(() -> new AppException(ConstantError.errorApp1));
        template.convertAndSend(topic.getTopic(), clientDecode.objectToJson(ClientMapper.INSTANCE.clientToClientRequest(client)));
        return ClientMapper.INSTANCE.clientToClientResponse(client);
    };
    @Override
    public ClientResponseDTO create(ClientRequestDTO clientRequestDTO){
        ClientEntity client = clientRep.save(ClientMapper.INSTANCE.clientRequestToClient(clientRequestDTO));
        return ClientMapper.INSTANCE.clientToClientResponse(client);
    }
    @Override
    public ClientResponseDTO update(int id, ClientRequestDTO clientRequestDTO){
        ClientEntity client = clientRep.findById(id).orElseThrow(() -> new AppException(ConstantError.errorApp1));
        client.setState(clientRequestDTO.getState());
        client.setPassword(clientRequestDTO.getPassword());
        client.setName(clientRequestDTO.getName());
        client.setGender(clientRequestDTO.getGender());
        client.setAge(clientRequestDTO.getAge());
        client.setIdentification(clientRequestDTO.getIdentification());
        client.setAddress(clientRequestDTO.getAddress());
        client.setPhone(clientRequestDTO.getPhone());
        return ClientMapper.INSTANCE.clientToClientResponse(clientRep.save(client));
    }
    @Override
    public void deleteById(int id){
        clientRep.findById(id).orElseThrow(() -> new AppException(ConstantError.errorApp1));
        clientRep.deleteById(id);
    }
}
