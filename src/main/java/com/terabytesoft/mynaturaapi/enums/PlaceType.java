package com.terabytesoft.mynaturaapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlaceType {

    QUADRA("Block"),
    BAIRRO("District"),
    SETOR("Sector"),
    RURAL("Rural");


    private final String description;
}
