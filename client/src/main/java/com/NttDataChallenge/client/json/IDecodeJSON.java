package com.NttDataChallenge.client.json;

import com.NttDataChallenge.client.dto.ClientRequestDTO;

public interface IDecodeJSON {
    String objectToJson(ClientRequestDTO clientRequestDTO);
}
