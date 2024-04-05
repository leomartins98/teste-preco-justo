package com.leonardo.duck.service;

import com.leonardo.duck.dto.request.RequestSaleDTO;
import com.leonardo.duck.dto.response.ResponseSaleDTO;
import com.leonardo.duck.entity.Client;
import com.leonardo.duck.entity.Duck;
import com.leonardo.duck.entity.Sale;
import com.leonardo.duck.repository.ClientRepository;
import com.leonardo.duck.repository.DuckRepository;
import com.leonardo.duck.repository.SaleRepository;
import com.leonardo.duck.util.DuckMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Primary
@RequiredArgsConstructor
public class SaleServiceImp implements SaleService{

    private final SaleRepository saleRepository;
    private final DuckMapper duckMapper;
    private final DuckRepository duckRepository;
    private final ClientRepository clientRepository;

    @Override
    public ResponseSaleDTO register(RequestSaleDTO requestSaleDTO) {

        Sale sale = new Sale();

        sale.setClientId(requestSaleDTO.getIdClient());
        sale.setDuckId(requestSaleDTO.getIdDuck());

        Client client = clientRepository.findById(requestSaleDTO.getIdClient()).orElseThrow(() -> new RuntimeException("Client not found"));
        sale.setClient(client);

        Duck duck = duckRepository.findById(requestSaleDTO.getIdDuck()).orElseThrow(() -> new RuntimeException("Duck not found"));
        sale.setDuck(duck);

        if (returnTypeClient(requestSaleDTO.getIdClient()).equals("Com Desconto") && findSon(requestSaleDTO.getIdDuck())) {
            sale.setPrice((float) (50-(50*20/100)));
        }
        else if(returnTypeClient(requestSaleDTO.getIdClient()).equals("Sem Desconto") && findSon(requestSaleDTO.getIdDuck())){
            sale.setPrice((float) 50);
        }
        if (returnTypeClient(requestSaleDTO.getIdClient()).equals("Com Desconto") && !findSon(requestSaleDTO.getIdDuck())) {
            sale.setPrice((float) (70-(70*20/100)));
        }
        else if(returnTypeClient(requestSaleDTO.getIdClient()).equals("Sem Desconto") && !findSon(requestSaleDTO.getIdDuck())){
            sale.setPrice((float) 70);
        }

        Sale savedSale = saleRepository.save(sale);

        return new ResponseSaleDTO(savedSale);

    }

    private String returnTypeClient(Long id) {
        return clientRepository.findTypeClient(id);
    }

    private Boolean findSon(Long id) {
        return duckRepository.findSon(id).size() > 0;
    }



}

