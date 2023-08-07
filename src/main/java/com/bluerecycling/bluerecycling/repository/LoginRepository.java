package com.bluerecycling.bluerecycling.repository;

import com.bluerecycling.bluerecycling.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findById(Long id);



}
