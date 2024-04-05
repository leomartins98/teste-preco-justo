package com.leonardo.duck.controller;

import com.leonardo.duck.dto.request.RequestClientDTO;
import com.leonardo.duck.dto.response.ResponseClientDTO;
import com.leonardo.duck.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ResponseClientDTO> register(@RequestBody RequestClientDTO requestClientDTO, UriComponentsBuilder uriBuilder) {

        ResponseClientDTO responseClientDTO = clientService.register(requestClientDTO);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(responseClientDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(responseClientDTO);
    }


}
