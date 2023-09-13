package fundatec.org.bluerecycling.repository;

import fundatec.org.bluerecycling.model.Residuo;
import fundatec.org.bluerecycling.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
//    Usuario findByCnpj(String cnpj);

    Usuario findByRazaoSocial(String razaoSocial);
    Optional<Usuario> findById(Long idUsuario);
    Usuario findByUserName(String userName);
    Usuario findByCnpj(String cnpj);
}
