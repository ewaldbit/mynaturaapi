package com.terabytesoft.mynaturaapi.utils;

import com.terabytesoft.mynaturaapi.dto.request.ClientDTO;
import com.terabytesoft.mynaturaapi.entity.Client;

import java.time.LocalDate;
import java.util.Collections;

public class ClientUtils {
    private static final String FIRST_NAME = "Ewald";
    private static final String LAST_NAME = "Bitencourt";
    private static final String CPF_NUMBER = "795.607.501-78";
    private static final long CLIENT_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(1978, 4, 29);

    public static ClientDTO createFakeDTO() {
        return ClientDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("29-04-1978")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Client createFakeEntity() {
        return Client.builder()
                .id(CLIENT_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
