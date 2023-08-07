package com.bluerecycling.bluerecycling.repository;

import com.bluerecycling.bluerecycling.model.Residuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResiduoRepository extends JpaRepository<Residuo, Long> {
    Residuo findByName(String nome);


}
