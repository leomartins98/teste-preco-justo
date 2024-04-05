package com.leonardo.duck.controller;

import com.leonardo.duck.dto.request.RequestSaleDTO;
import com.leonardo.duck.dto.response.ResponseSaleDTO;
import com.leonardo.duck.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<ResponseSaleDTO> register(@RequestBody RequestSaleDTO requestSaleDTO, UriComponentsBuilder uriBuilder) {

        ResponseSaleDTO responseSaleDTO = saleService.register(requestSaleDTO);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(responseSaleDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(responseSaleDTO);
    }

}
