package com.terabytesoft.mynaturaapi.service;

import com.terabytesoft.mynaturaapi.dto.ClientDTO;
import com.terabytesoft.mynaturaapi.dto.MessageResponseDTO;
import com.terabytesoft.mynaturaapi.entity.Client;
import com.terabytesoft.mynaturaapi.exception.ClientNotFoundException;
import com.terabytesoft.mynaturaapi.mapper.ClientMapper;
import com.terabytesoft.mynaturaapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    private final ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public MessageResponseDTO createClient(ClientDTO clientDTO) {

        Client clientToSave = clientMapper.ToModel(clientDTO);

        Client savedClient = clientRepository.save(clientToSave);
        return createMessageResponse(savedClient.getId(), "Client saved with id: ");
    }

    public List<ClientDTO> listAll() {
        List<Client> allClients = clientRepository.findAll();
        return allClients.stream()
                .map(clientMapper::ToDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO findById(Long id) throws ClientNotFoundException {
        Client client = verifyIfExists(id);
        return clientMapper.ToDTO(client);
    }

    public void deleteById(Long id) throws ClientNotFoundException {
        verifyIfExists(id);
        clientRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, ClientDTO clientDTO) throws ClientNotFoundException {

        verifyIfExists(id);
        Client clientToUpdate = clientMapper.ToModel(clientDTO);

        Client updatedClient = clientRepository.save(clientToUpdate);
        return createMessageResponse(updatedClient.getId(), "Client updated with id: ");
    }

    private Client verifyIfExists(Long id) throws ClientNotFoundException {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
