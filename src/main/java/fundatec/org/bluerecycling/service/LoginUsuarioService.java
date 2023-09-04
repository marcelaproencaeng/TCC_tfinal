package fundatec.org.bluerecycling.service;

import fundatec.org.bluerecycling.dto.LoginUsuarioDTO;
import fundatec.org.bluerecycling.model.LoginUsuario;
import fundatec.org.bluerecycling.repository.LoginUsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class LoginUsuarioService {
    private final LoginUsuarioRepository loginUsuarioRepository;

    public LoginUsuarioService(LoginUsuarioRepository loginUsuarioRepository) {
        this.loginUsuarioRepository = loginUsuarioRepository;
    }

    public LoginUsuario adicionarLogin(LoginUsuarioDTO loginUsuarioDTO) {
        LoginUsuario loginASerAdicionado = new LoginUsuario();
        loginASerAdicionado.setCnpj(loginUsuarioDTO.getCnpj());
        loginASerAdicionado.setSenha(loginUsuarioDTO.getSenha());
        LoginUsuario loginUsuario = findByCnpj(loginASerAdicionado.getCnpj());

        if (loginUsuario != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login" + loginUsuario.getCnpj()
                    + "já existe!");
        }
        return loginUsuarioRepository.save(loginASerAdicionado);

    }

    public List<LoginUsuario> buscarTodos() {
        return loginUsuarioRepository.findAll();
    }

    public void deletar(String cnpj) {
        LoginUsuario loginParaRemover = findByCnpj(cnpj);
        if (loginParaRemover == null) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não é possível remover um login por cnpj inexistente");
        }
        loginUsuarioRepository.delete(loginParaRemover);
    }
//      public void deletar(String userName) {
//        Usuario usuarioParaRemover = findByUsername(userName);
//        if (usuarioParaRemover == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                    "Não é possível remover usuário inexistente");
//        }
//        usuarioRepository.delete(usuarioParaRemover);
//    }

    private Optional<LoginUsuario> findById(Long id) {
        return loginUsuarioRepository.findById(id);
    }

    public LoginUsuario findByCnpj(String cnpj) {
        return loginUsuarioRepository.findByCnpj(cnpj);
    }

    public LoginUsuario atualizarLoginPorId(String novaSenha, Long id) {

        Optional<LoginUsuario> loginUsuarioOptional = loginUsuarioRepository.findById(id);
        if (loginUsuarioOptional.isPresent()) {
            LoginUsuario login = loginUsuarioOptional.get();
            login.setSenha(novaSenha);
            return loginUsuarioRepository.save(login);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Login de usuário não encontrado com o id, impossível atualizar a senha" + id);
        }
    }
}
