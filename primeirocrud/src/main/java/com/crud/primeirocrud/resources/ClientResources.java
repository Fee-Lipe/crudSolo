package com.crud.primeirocrud.resources;

import com.crud.primeirocrud.dto.ClientDTO;
import com.crud.primeirocrud.entities.Client;
import com.crud.primeirocrud.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientResources {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll(){

        List<ClientDTO> list = clientService.findAll();

        return ResponseEntity.ok().body(list);
    }
}
