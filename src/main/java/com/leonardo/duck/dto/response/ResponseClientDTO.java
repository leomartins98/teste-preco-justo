package com.leonardo.duck.dto.response;

import com.leonardo.duck.entity.Client;
import lombok.Getter;

@Getter
public class ResponseClientDTO {

    private Long id;

    private String name;

    private String type;

    public ResponseClientDTO(Client client) {

        this.id = client.getId();
        this.name = client.getName();
        this.type = client.getType();

    }

}
