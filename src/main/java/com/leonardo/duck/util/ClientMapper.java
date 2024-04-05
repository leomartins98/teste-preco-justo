package com.leonardo.duck.util;

import com.leonardo.duck.dto.request.RequestClientDTO;
import com.leonardo.duck.dto.response.ResponseClientDTO;
import com.leonardo.duck.entity.Client;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public Client toClient(RequestClientDTO requestClientDTO) {

            return Client.builder()
                    .name(requestClientDTO.getName())
                    .type(requestClientDTO.getType())
                    .build();
    }

    public ResponseClientDTO toRequestClientDTO(Client client) {

        return new ResponseClientDTO(client);
    }

    public List<ResponseClientDTO> toClientsDTO(List<Client> peopleList) {

            return peopleList.stream().map(ResponseClientDTO::new).collect(Collectors.toList());
    }

}
