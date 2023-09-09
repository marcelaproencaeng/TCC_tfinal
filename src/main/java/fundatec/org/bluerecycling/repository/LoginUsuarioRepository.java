package fundatec.org.bluerecycling.repository;

import fundatec.org.bluerecycling.model.LoginUsuario;
import fundatec.org.bluerecycling.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LoginUsuarioRepository extends JpaRepository<LoginUsuario, Long> {


    LoginUsuario findByUserName(String userName);

    LoginUsuario findByCnpj(String cnpj);


}
