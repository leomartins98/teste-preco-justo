package com.leonardo.duck.repository;

import com.leonardo.duck.entity.Duck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DuckRepository extends JpaRepository<Duck, Long> {

    @Query(value = "SELECT * FROM ducks d WHERE d.id_mae = :id", nativeQuery = true)
    List<Duck> findSon(Long id);

}
