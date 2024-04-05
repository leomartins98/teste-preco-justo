package com.leonardo.duck.dto.request;

import com.leonardo.duck.entity.Duck;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequestSaleDTO {

    private Long idDuck;

    private Long idClient;

}
