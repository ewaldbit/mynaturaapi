package com.terabytesoft.mynaturaapi.mapper;

import com.terabytesoft.mynaturaapi.dto.request.ClientDTO;
import com.terabytesoft.mynaturaapi.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Client ToModel(ClientDTO clientDTO);

    ClientDTO ToDTO(Client client);
}
