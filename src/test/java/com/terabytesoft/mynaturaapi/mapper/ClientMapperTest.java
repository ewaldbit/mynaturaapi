package com.terabytesoft.mynaturaapi.mapper;

import com.terabytesoft.mynaturaapi.dto.request.ClientDTO;
import com.terabytesoft.mynaturaapi.dto.request.PhoneDTO;
import com.terabytesoft.mynaturaapi.entity.Client;
import com.terabytesoft.mynaturaapi.entity.Phone;
import com.terabytesoft.mynaturaapi.utils.ClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClientMapperTest {

    @Autowired
    private ClientMapper clientMapper;

    @Test
    void testClientDTOThenReturnClientEntity() {
        ClientDTO clientDTO = ClientUtils.createFakeDTO();
        Client client = clientMapper.ToModel(clientDTO);

        assertEquals(clientDTO.getFirstName(), client.getFirstName());
        assertEquals(clientDTO.getLastName(), client.getLastName());
        assertEquals(clientDTO.getCpf(), client.getCpf());

        Phone phone = client.getPhones().get(0);
        PhoneDTO phoneDTO = clientDTO.getPhones().get(0);

        assertEquals(phoneDTO.getType(), phone.getType());
        assertEquals(phoneDTO.getNumber(), phone.getNumber());
    }

    @Test
    void testClientEntityThenReturnClientDTO() {
        Client client = ClientUtils.createFakeEntity();
        ClientDTO clientDTO = clientMapper.ToDTO(client);

        assertEquals(client.getFirstName(), clientDTO.getFirstName());
        assertEquals(client.getLastName(), clientDTO.getLastName());
        assertEquals(client.getCpf(), clientDTO.getCpf());

        Phone phone = client.getPhones().get(0);
        PhoneDTO phoneDTO = clientDTO.getPhones().get(0);

        assertEquals(phone.getType(), phoneDTO.getType());
        assertEquals(phone.getNumber(), phoneDTO.getNumber());
    }

}
