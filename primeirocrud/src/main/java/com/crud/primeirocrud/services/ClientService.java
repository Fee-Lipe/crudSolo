package com.crud.primeirocrud.services;

import com.crud.primeirocrud.dto.ClientDTO;
import com.crud.primeirocrud.entities.Client;
import com.crud.primeirocrud.repositories.ClientRepository;
import com.crud.primeirocrud.services.exceptions.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<ClientDTO> findAll(){
        List<Client> list = clientRepository.findAll();

        return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> obj = clientRepository.findById(id);
        Client entity = obj.orElseThrow(() -> new EntityNotFoundException("Enitity not found"));
        return new ClientDTO(entity);
    }
}
