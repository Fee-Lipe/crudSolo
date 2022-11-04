package com.crud.primeirocrud.services;

import com.crud.primeirocrud.dto.ClientDTO;
import com.crud.primeirocrud.entities.Client;
import com.crud.primeirocrud.repositories.ClientRepository;
import com.crud.primeirocrud.services.exceptions.DatabaseException;
import com.crud.primeirocrud.services.exceptions.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        Client entity = obj.orElseThrow(() -> new ResouceNotFoundException("Enitity not found"));
        return new ClientDTO(entity);
    }
    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyToEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }
    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client entity = clientRepository.getReferenceById(id);
            copyToEntity(dto, entity);
            entity = clientRepository.save(entity);
            return new ClientDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResouceNotFoundException("ID NOT FOUND" + id);
        }
    }
    public void delete(Long id) {
        try {
            clientRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResouceNotFoundException("ID NOT FOUND" + id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integraty violation");
        }
    }
    private void copyToEntity(ClientDTO dto, Client entity){
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setBirthDate(dto.getBirthDate());
        entity.setIncome(dto.getIncome());
        entity.setChildren(dto.getChildren());
    }
}
