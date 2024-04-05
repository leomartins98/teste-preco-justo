package com.leonardo.duck.util;

import com.leonardo.duck.dto.request.RequestDuckDTO;
import com.leonardo.duck.dto.response.ResponseDuckDTO;
import com.leonardo.duck.entity.Duck;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DuckMapper {

    public Duck toDuck(RequestDuckDTO requestDuckDTO) {

        return Duck.builder()
                .name(requestDuckDTO.getName())
                .maeId(requestDuckDTO.getMae())
                .build();
    }

    public ResponseDuckDTO toRequestDuckDTO(Duck duck) {

        return new ResponseDuckDTO(duck);

    }

    public List<ResponseDuckDTO> toDucksDTO(List<Duck> ducksList) {

        return ducksList.stream().map(ResponseDuckDTO::new).collect(Collectors.toList());
    }

}
