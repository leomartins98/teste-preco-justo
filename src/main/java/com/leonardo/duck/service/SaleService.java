package com.leonardo.duck.service;

import com.leonardo.duck.dto.request.RequestSaleDTO;
import com.leonardo.duck.dto.response.ResponseSaleDTO;

import java.util.List;

public interface SaleService {

    ResponseSaleDTO register(RequestSaleDTO saleDTO);

}
