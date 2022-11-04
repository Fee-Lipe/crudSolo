package com.crud.primeirocrud.services;

import com.crud.primeirocrud.dto.ClientDTO;
import com.crud.primeirocrud.entities.Client;
import com.crud.primeirocrud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> findAll(){
        List<Client> list = clientRepository.findAll();

        return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
    }
}
