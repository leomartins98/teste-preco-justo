package com.leonardo.duck.controller;

import com.leonardo.duck.dto.request.RequestClientDTO;
import com.leonardo.duck.dto.request.RequestDuckDTO;
import com.leonardo.duck.dto.response.ResponseClientDTO;
import com.leonardo.duck.dto.response.ResponseDuckDTO;
import com.leonardo.duck.service.DuckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/duck")
@RequiredArgsConstructor
public class DuckController {

    private final DuckService duckService;

    @PostMapping
    public ResponseEntity<ResponseDuckDTO> register(@RequestBody RequestDuckDTO requestDuckDTO, UriComponentsBuilder uriBuilder) {

        ResponseDuckDTO responseDuckDTO = duckService.register(requestDuckDTO);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(responseDuckDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(responseDuckDTO);
    }

}
