package com.leonardo.duck.service;

import com.leonardo.duck.dto.request.RequestClientDTO;
import com.leonardo.duck.dto.response.ResponseClientDTO;
import com.leonardo.duck.entity.Client;
import com.leonardo.duck.repository.ClientRepository;
import com.leonardo.duck.util.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class ClientServiceImp implements ClientService{

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ResponseClientDTO register(RequestClientDTO clientDTO) {

        Client client  = clientMapper.toClient(clientDTO);
        return clientMapper.toRequestClientDTO(clientRepository.save(client));

    }

}
