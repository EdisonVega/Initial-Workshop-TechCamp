package sb.techcamp.bankapi.dto.mapper;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import sb.techcamp.bankapi.dto.ClientDTO;
import sb.techcamp.bankapi.model.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(target = "id", source = "ClientId"),
            @Mapping(target = "document", source = "clientDocument"),
            @Mapping(target = "firstName", source = "clientName"),
            @Mapping(target = "lastName", source = "clientLastname"),
            @Mapping(target = "phone", source = "clientPhone"),
            @Mapping(target = "email", source = "clientEmail"),
            @Mapping(target = "password", source = "clientPassword"),
            @Mapping(target = "active", source = "clientActive")
    })
    ClientDTO toClientDTO(Client client);

    @InheritInverseConfiguration
    @Mapping(target = "clientSex", ignore = true)
    @Mapping(target = "clientAddress", ignore = true)
    @Mapping(target = "clientAccounts", ignore = true)
    Client toClient(ClientDTO clientDTO);
}
