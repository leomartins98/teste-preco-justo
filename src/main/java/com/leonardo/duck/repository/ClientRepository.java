package com.leonardo.duck.repository;

import com.leonardo.duck.dto.response.ResponseClientDTO;
import com.leonardo.duck.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

    @Query(value = "SELECT type FROM clients c WHERE c.id = :id", nativeQuery = true)
    String findTypeClient(Long id);

}
