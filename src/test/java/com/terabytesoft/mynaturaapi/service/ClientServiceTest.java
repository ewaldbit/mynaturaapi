package com.terabytesoft.mynaturaapi.service;

import com.terabytesoft.mynaturaapi.dto.request.ClientDTO;
import com.terabytesoft.mynaturaapi.dto.MessageResponseDTO;
import com.terabytesoft.mynaturaapi.entity.Client;
import com.terabytesoft.mynaturaapi.mapper.ClientMapper;
import com.terabytesoft.mynaturaapi.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.terabytesoft.mynaturaapi.utils.ClientUtils.createFakeDTO;
import static com.terabytesoft.mynaturaapi.utils.ClientUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientService clientService;

    @Test
    void testClientDTOThenReturnSuccessSavedMessage() {
        ClientDTO clientDTO = createFakeDTO();
        Client expectedSavedClient = createFakeEntity();

        when(clientRepository.save(any(Client.class))).thenReturn(expectedSavedClient);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedClient.getId());
        MessageResponseDTO successMessage = clientService.createClient(clientDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedClientId) {
        return MessageResponseDTO.builder()
                .message("Client successfully created with ID: " + savedClientId)
                .build();
    }



}
