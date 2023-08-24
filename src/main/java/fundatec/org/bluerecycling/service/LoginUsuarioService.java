package fundatec.org.bluerecycling.service;

import fundatec.org.bluerecycling.dto.LoginUsuarioDTO;
import fundatec.org.bluerecycling.model.LoginUsuarioModel;
import fundatec.org.bluerecycling.repository.LoginUsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LoginUsuarioService {
    private final LoginUsuarioRepository loginUsuarioRepository;

    public LoginUsuarioService(LoginUsuarioRepository loginUsuarioRepository) {
        this.loginUsuarioRepository = loginUsuarioRepository;
    }

    public LoginUsuarioModel adicionarLogin(LoginUsuarioDTO loginUsuarioDTO) {
        LoginUsuarioModel loginASerAdicionado = new LoginUsuarioModel();
        loginASerAdicionado.setCnpj(loginUsuarioDTO.getCnpj());
        loginASerAdicionado.setSenha(loginUsuarioDTO.getSenha());

        Optional<LoginUsuarioModel> login;
        Long meuId = loginASerAdicionado.getId();
        login = findById(meuId);
        if (login.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login" + login.get().getId()
                    + "já existe!");
        }
        loginUsuarioRepository.save(loginASerAdicionado);
        return loginASerAdicionado;
    }

    private Optional<LoginUsuarioModel> findById(Long id) {
        return loginUsuarioRepository.findById(id);
    }
}
