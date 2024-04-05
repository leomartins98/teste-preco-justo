package com.leonardo.duck.service;

import com.leonardo.duck.dto.request.RequestDuckDTO;
import com.leonardo.duck.dto.response.ResponseDuckDTO;
import com.leonardo.duck.entity.Duck;
import com.leonardo.duck.repository.DuckRepository;
import com.leonardo.duck.util.DuckMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class DuckServiceImp implements DuckService{

    private final DuckRepository duckRepository;
    private final DuckMapper duckMapper;

    @Override
    public ResponseDuckDTO register(RequestDuckDTO requestDuckDTO) {
        Duck duck = new Duck();
        duck.setName(requestDuckDTO.getName());

        if (requestDuckDTO.getMae() != null) {
            Duck mae = duckRepository.findById(requestDuckDTO.getMae()).orElse(null);
            duck.setMae(mae);
        }
        else {
            duck.setMae(null);
        }

        Duck savedDuck = duckRepository.save(duck);

        return new ResponseDuckDTO(savedDuck);
    }

    private Duck returnDuck(Long id) {
        return duckRepository.findById(id).orElseThrow(() -> new RuntimeException("Duck not found"));
    }

}

