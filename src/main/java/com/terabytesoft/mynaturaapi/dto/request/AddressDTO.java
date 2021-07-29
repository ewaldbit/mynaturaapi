package com.terabytesoft.mynaturaapi.dto.request;

import com.terabytesoft.mynaturaapi.enums.PlaceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PlaceType placeType;

    @NotEmpty
    @Size(min = 5, max = 50)
    private String publicPlace;

    @NotEmpty
    @Size(min = 1, max = 10)
    private String number;

    @NotEmpty
    @Size(min = 5, max = 8)
    private String cep;

}
