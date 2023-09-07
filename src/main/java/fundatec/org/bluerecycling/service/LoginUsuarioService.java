package fundatec.org.bluerecycling.service;

import fundatec.org.bluerecycling.dto.*;
import fundatec.org.bluerecycling.model.LoginUsuario;
import fundatec.org.bluerecycling.model.Usuario;
import fundatec.org.bluerecycling.repository.LoginUsuarioRepository;
import fundatec.org.bluerecycling.repository.ResiduoRepository;
import fundatec.org.bluerecycling.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class LoginUsuarioService {
    private final LoginUsuarioRepository loginUsuarioRepository;
    private final ResiduoRepository residuoRepository;
    private final UsuarioRepository usuarioRepository;

    public LoginUsuarioService(LoginUsuarioRepository loginUsuarioRepository,
                               ResiduoRepository residuoRepository, UsuarioRepository usuarioRepository) {
        this.loginUsuarioRepository = loginUsuarioRepository;
        this.residuoRepository = residuoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public LoginUsuario adicionarLogin(LoginUsuarioDTO loginUsuarioDTO,UsuarioDTO usuarioDTO) {

        Usuario usuario = usuarioRepository.findByCnpj(usuarioDTO.getCnpj());

//        Optional<Residuo> residuo = residuoRepository.findById(residuoDTO.getIdResiduo());
        if (usuario.usuarioExists(usuario) == false | usuario == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Login inválido" + usuario.getCnpj() +
                            "usuário não existe e/ou não está cadastrado");
        }
//        Usuario usuarioASerAdicionado = new Usuario();
//        usuarioASerAdicionado.setCnpj(usuarioDTO.getCnpj());
//        usuarioASerAdicionado.setResiduo(usuarioDTO.getResiduo());
//        usuarioASerAdicionado.setPlano(usuarioDTO.getPlano());
//        usuarioASerAdicionado.setContato(usuarioDTO.getContato());
//        usuarioASerAdicionado.setEmail(usuarioDTO.getEmail());
//        usuarioASerAdicionado.setHasTransporte(usuarioDTO.getHasTransporte());
//        usuarioASerAdicionado.setHasResiduo(usuarioDTO.getHasResiduo());
//        usuarioASerAdicionado.setRazaoSocial(usuarioDTO.getRazaoSocial());
//        Usuario usuario1 = findByRazaoSocial(usuarioASerAdicionado.getCnpj());
//        if (usuario1 != null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário" + usuario1.getCnpj() +
//                    "já existe!");
//        }
        LoginUsuario loginASerAdicionado = new LoginUsuario();
        loginASerAdicionado.setUserName(loginUsuarioDTO.getUserName());
        loginASerAdicionado.setSenha(loginUsuarioDTO.getSenha());
        LoginUsuario loginUsuario = findByUserName(loginASerAdicionado.getUserName());
        loginUsuarioRepository.save(loginASerAdicionado);
         return loginASerAdicionado;
    }

    private LoginUsuario findByUserName(String userName) {
        loginUsuarioRepository.findByUserName(userName);

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
    public Usuario findByRazaoSocial(String razaoSocial) {
        return usuarioRepository.findByRazaoSocial(razaoSocial);
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
