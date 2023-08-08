package com.bluerecycling.bluerecycling.repository;

import com.bluerecycling.bluerecycling.model.Plano;
import com.bluerecycling.bluerecycling.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {
    Optional<Plano> findByAssinante(Usuario assinante);

    void delete(Optional<Plano> planoParaRemover);
}
