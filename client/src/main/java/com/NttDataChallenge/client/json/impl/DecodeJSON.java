package com.NttDataChallenge.client.json.impl;

import com.NttDataChallenge.client.dto.ClientRequestDTO;
import com.NttDataChallenge.client.exception.AppException;
import com.NttDataChallenge.client.exception.ConstantError;
import com.NttDataChallenge.client.json.IDecodeJSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DecodeJSON implements IDecodeJSON {
    public String objectToJson(ClientRequestDTO clientRequestDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(clientRequestDTO);
        } catch (JsonProcessingException e) {
            throw new AppException(ConstantError.errorApp1);
        }
    }
}
