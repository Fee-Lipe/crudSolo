package com.crud.primeirocrud.services;

import com.crud.primeirocrud.dto.ClientDTO;
import com.crud.primeirocrud.entities.Client;
import com.crud.primeirocrud.repositories.ClientRepository;
import com.crud.primeirocrud.services.exceptions.DatabaseException;
import com.crud.primeirocrud.services.exceptions.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(PageRequest pageRequest){
        Page<Client> list = clientRepository.findAll(pageRequest);
        return list.map(x -> new ClientDTO(x));
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
