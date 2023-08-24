package com.bluerecycling.bluerecycling.repository;

import com.bluerecycling.bluerecycling.model.LoginUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LoginUsuarioRepository extends JpaRepository<LoginUsuario, Long> {
    Optional<LoginUsuario> findById(Long id);





}
