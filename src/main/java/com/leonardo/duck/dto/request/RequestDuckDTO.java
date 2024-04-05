package com.leonardo.duck.dto.request;

import com.leonardo.duck.entity.Duck;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequestDuckDTO {

    private String name;

    private Long mae;

}
