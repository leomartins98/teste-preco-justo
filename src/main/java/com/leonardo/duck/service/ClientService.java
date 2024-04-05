package com.leonardo.duck.service;

import com.leonardo.duck.dto.request.RequestClientDTO;
import com.leonardo.duck.dto.response.ResponseClientDTO;

import java.util.List;

public interface ClientService {

    ResponseClientDTO register(RequestClientDTO clientDTO);

}
