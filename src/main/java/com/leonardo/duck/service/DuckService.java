package com.leonardo.duck.service;

import com.leonardo.duck.dto.request.RequestDuckDTO;
import com.leonardo.duck.dto.response.ResponseDuckDTO;

import java.util.List;

public interface DuckService {

    ResponseDuckDTO register(RequestDuckDTO duckDTO);


}
