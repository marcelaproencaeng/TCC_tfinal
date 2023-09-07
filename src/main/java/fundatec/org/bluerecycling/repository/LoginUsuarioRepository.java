package fundatec.org.bluerecycling.repository;

import fundatec.org.bluerecycling.model.LoginUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginUsuarioRepository extends JpaRepository<LoginUsuario, Long> {
    Optional<LoginUsuario> findById(Long id);

    LoginUsuario findByCnpj(String cnpj);

    void findByUserName(String userName);
}
