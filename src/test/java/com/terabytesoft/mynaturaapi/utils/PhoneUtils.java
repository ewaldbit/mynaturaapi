package com.terabytesoft.mynaturaapi.utils;

import com.terabytesoft.mynaturaapi.dto.request.PhoneDTO;
import com.terabytesoft.mynaturaapi.entity.Phone;
import com.terabytesoft.mynaturaapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "(63)99999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;


    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

}
