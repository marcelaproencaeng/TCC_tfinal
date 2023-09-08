package fundatec.org.bluerecycling.service;

import fundatec.org.bluerecycling.dto.*;
import fundatec.org.bluerecycling.model.LoginUsuario;
import fundatec.org.bluerecycling.model.Usuario;
import fundatec.org.bluerecycling.repository.LoginUsuarioRepository;
import fundatec.org.bluerecycling.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class LoginUsuarioService {
    private final LoginUsuarioRepository loginUsuarioRepository;
    private final UsuarioRepository usuarioRepository;

    public LoginUsuarioService(LoginUsuarioRepository loginUsuarioRepository,
                               UsuarioRepository usuarioRepository) {
        this.loginUsuarioRepository = loginUsuarioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public LoginUsuario adicionarLogin(LoginUsuarioDTO loginUsuarioDTO) {

        Usuario usuario = usuarioRepository.findByCnpj(loginUsuarioDTO.getUserName());

//        Optional<Residuo> residuo = residuoRepository.findById(residuoDTO.getIdResiduo());
        if (usuario.usuarioExists(usuario) == false | usuario == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Login inválido" + usuario.getCnpj() +
                            "usuário não existe e/ou não está cadastrado");

        }

        Usuario usuarioASerAdicionado = new Usuario();
        usuarioASerAdicionado.setCnpj(usuario.getCnpj());
        usuarioASerAdicionado.setResiduos(usuario.getResiduos());
//        usuarioASerAdicionado.setPlano(usuario.getPlano());
//        usuarioASerAdicionado.setContato(usuario.getContato());
        usuarioASerAdicionado.setEmail(usuario.getEmail());
        usuarioASerAdicionado.setHasTransporte(usuario.getHasTransporte());
        usuarioASerAdicionado.setHasResiduo(usuario.getHasResiduo());
        usuarioASerAdicionado.setRazaoSocial(usuario.getRazaoSocial());

        Usuario usuario1 = findByCnpj(usuarioASerAdicionado.getCnpj());
        if (usuario1 != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário" + usuario1.getCnpj() +
                    "já existe!");

        }

        LoginUsuario loginASerAdicionado = new LoginUsuario();
        loginASerAdicionado.setUserName(loginUsuarioDTO.getUserName());
        loginASerAdicionado.setSenha(loginUsuarioDTO.getSenha());
        LoginUsuario loginUsuario = findByUserName(loginASerAdicionado.getUserName());
        loginUsuarioRepository.save(loginASerAdicionado);
        return loginASerAdicionado;
    }

    private Usuario findByCnpj(String cnpj) {

        return loginUsuarioRepository.findByCnpj(cnpj);
    }

    public List<LoginUsuario> buscarTodos() {

        return loginUsuarioRepository.findAll();
    }

//    public ResponseEntity LoginUsuario (ResiduoDTO residuoDTO, LoginUsuarioDTO loginUsuarioDTO) {
//
//        Residuo residuo1 = residuoRepository.findByNome(residuoDTO.getNome());
//        if (residuo1 == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                    "Resíduo" + residuo1.getNome() + "Resíduo não cadastrado não tem login!");
//        }
//        LoginUsuario loginASerAdicionado = new LoginUsuario();
//        loginASerAdicionado.setCnpj(loginUsuarioDTO.getCnpj());
//        loginASerAdicionado.setSenha(loginUsuarioDTO.getSenha());
//        LoginUsuario loginUsuario = loginUsuarioRepository.findByCnpj(loginASerAdicionado.getCnpj());
//
//
//
//        return loginUsuarioRepository.save(loginASerAdicionado);
//    }

    //    public List<LoginUsuario> buscarTodos(List<Residuo> residuos) {
//
//        LoginUsuario loginASerAdicionado = new LoginUsuario();
//        loginASerAdicionado.setCnpj(residuos.get().getIdResiduo());
//        loginASerAdicionado.setSenha(loginUsuarioDTO.getSenha());
//        LoginUsuario loginUsuario = findByCnpj(loginASerAdicionado.getCnpj());
//
//        Residuo residuoASerEncontrado = new Residuo();
//        Optional List<Residuo> residuos = findById(residuoASerEncontrado.getIdResiduo());
//
//        if (residuos.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Resíduos" + residuoASerEncontrado.getNome()
//                    + "já existe!");
//        }
//
//        return loginUsuarioRepository.findAll();
//
//    }

    public void deletar(String userName) {
        LoginUsuario loginParaRemover = findByUserName(userName);
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

    public LoginUsuario findByUserName(String userName) {
        return loginUsuarioRepository.findByUserName(userName);
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
