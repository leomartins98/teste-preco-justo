package com.leonardo.duck.repository;

import com.leonardo.duck.entity.Client;
import com.leonardo.duck.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {



}
