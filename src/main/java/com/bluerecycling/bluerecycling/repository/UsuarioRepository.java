package com.bluerecycling.bluerecycling.repository;

import com.bluerecycling.bluerecycling.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByRazaoSocial(String razaoSocial);
}
