package fundatec.org.bluerecycling.repository;

import fundatec.org.bluerecycling.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByCnpj(String cnpj);

    Usuario findByRazaoSocial(String razaoSocial);
}
