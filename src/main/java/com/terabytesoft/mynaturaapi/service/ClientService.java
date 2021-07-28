package com.terabytesoft.mynaturaapi.service;

import com.terabytesoft.mynaturaapi.dto.ClientDTO;
import com.terabytesoft.mynaturaapi.dto.MessageResponseDTO;
import com.terabytesoft.mynaturaapi.entity.Client;
import com.terabytesoft.mynaturaapi.mapper.ClientMapper;
import com.terabytesoft.mynaturaapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    private ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public MessageResponseDTO createClient(ClientDTO clientDTO) {

        Client clientToSave = clientMapper.ToModel(clientDTO);

        Client savedClient = clientRepository.save(clientToSave);
        return MessageResponseDTO
                .builder()
                .message("Client saved with id: " + savedClient.getId())
                .build();
    }
}
