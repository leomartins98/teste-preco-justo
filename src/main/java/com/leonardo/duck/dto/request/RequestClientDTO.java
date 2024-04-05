package com.leonardo.duck.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequestClientDTO {

    private String name;

    private String type;

}
