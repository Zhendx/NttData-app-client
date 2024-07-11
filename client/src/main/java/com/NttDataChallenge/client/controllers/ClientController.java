package com.NttDataChallenge.client.controllers;

import com.NttDataChallenge.client.dto.ClientDTO;
import com.NttDataChallenge.client.dto.ClientResponseDTO;
import com.NttDataChallenge.client.mapper.ClientMapper;
import com.NttDataChallenge.client.services.IClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final IClient clientService;
    @GetMapping("/list")
    public ResponseEntity<List<ClientResponseDTO>> listClients(){
        return ResponseEntity.ok(clientService.getAllClients());
    }
    @GetMapping("/{id}/view")
    public ResponseEntity<ClientResponseDTO> listClientId(@PathVariable int id){
        return ResponseEntity.ok(clientService.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientDTO clientDTO){
        return ResponseEntity.ok(clientService.create(ClientMapper.INSTANCE.clientDTOToClientRequestDTO(clientDTO)));
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable int id, @RequestBody ClientDTO clientDTO){
        return ResponseEntity.ok(clientService.update(id, ClientMapper.INSTANCE.clientDTOToClientRequestDTO(clientDTO)));
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteClient(@PathVariable int id){
        clientService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
