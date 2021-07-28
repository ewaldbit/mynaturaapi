package com.terabytesoft.mynaturaapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("Home"),
    MOBLIE("Mobile"),
    COMMERCIAL("Commercial");

    private final String description;
}
