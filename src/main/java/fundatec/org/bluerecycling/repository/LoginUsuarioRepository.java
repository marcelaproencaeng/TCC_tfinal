package fundatec.org.bluerecycling.repository;

import fundatec.org.bluerecycling.model.LoginUsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginUsuarioRepository extends JpaRepository<LoginUsuarioModel, Long> {
    Optional<LoginUsuarioModel> findById(Long id);
}
