package fundatec.org.bluerecycling.service;

import fundatec.org.bluerecycling.dto.*;
import fundatec.org.bluerecycling.model.LoginUsuario;
import fundatec.org.bluerecycling.model.Usuario;
import fundatec.org.bluerecycling.repository.LoginUsuarioRepository;
import fundatec.org.bluerecycling.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public LoginUsuario adicionarLogin(CriarLoginUsuarioDTO criarLoginUsuarioDTO) {

        Usuario usuario = usuarioRepository.findByCnpj(criarLoginUsuarioDTO.getUserName());

//        Optional<Residuo> residuo = residuoRepository.findById(residuoDTO.getIdResiduo());
        if (usuario == null || !usuario.usuarioExists(usuario) || !usuario.userNameValue(usuario)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Login inválido" + criarLoginUsuarioDTO.getUserName() +
                            "usuário não existe e/ou não está cadastrado");

        }
//        LoginUsuario loginUsuario = criarLoginUsuarioDTO.getSenha();
//        LoginUsuario loginUsuario1 = criarLoginUsuarioDTO.getUserName();
//
//        if (loginUsuario1.equals("12345678901234") && loginUsuario.equals("admin")) {
//            return ResponseEntity.status(HttpStatus.OK).build();


        LoginUsuario loginASerAdicionado = new LoginUsuario();
        loginASerAdicionado.setUserName(criarLoginUsuarioDTO.getUserName());
        loginASerAdicionado.setPassword(criarLoginUsuarioDTO.getPassword());
        loginUsuarioRepository.save(loginASerAdicionado);
        return loginASerAdicionado;


//        LoginUsuario novoLoginUsuario = new LoginUsuario();
//        novoLoginUsuario.setUsuario(usuario);
//
//        Usuario usuarioASerAdicionado = new Usuario();
//        usuarioASerAdicionado.setCnpj(usuario.getCnpj());
////        usuarioASerAdicionado.setResiduos(usuario.getResiduos());
////      usuarioASerAdicionado.setPlano(usuario.getPlano());
////      usuarioASerAdicionado.setContato(usuario.getContato());
//        usuarioASerAdicionado.setEmail(usuario.getEmail());
//        usuarioASerAdicionado.setHasTransporte(usuario.getHasTransporte());
//        usuarioASerAdicionado.setHasResiduoDeInteresse(usuario.getHasResiduoDeInteresse());
//        usuarioASerAdicionado.setRazaoSocial(usuario.getRazaoSocial());
//
//        Optional<Usuario> usuario1 = findById(usuarioASerAdicionado.getIdUsuario());
//        if (usuario1.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário"
//                    + usuario1.get().getIdUsuario() +
//                    "não existe!");
//
//
//        }
//
//        LoginUsuario novoLoginASerAdicionado = new LoginUsuario();
//        novoLoginASerAdicionado.setUserName(criarLoginUsuarioDTO.getUserName());
//        novoLoginASerAdicionado.setSenha(criarLoginUsuarioDTO.getSenha());
//        LoginUsuario loginUsuario = findByUserName(novoLoginASerAdicionado.getUserName());
//        if (loginUsuario != null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login" +
//                    loginUsuario.getUserName() +
//                    "já existe!");
//
//        }

//        loginUsuarioRepository.save(novoLoginASerAdicionado);
//        return String.valueOf(novoLoginASerAdicionado);

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
                    "Não é possível remover um login por UserName inexistente");
        }
        loginUsuarioRepository.delete(loginParaRemover);
    }

    private Optional<Usuario> findById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public LoginUsuario findByUserName(String userName) {
        return loginUsuarioRepository.findByUserName(userName);
    }

    public LoginUsuario atualizarLoginPorId(String novaSenha, Long id) {

        Optional<LoginUsuario> loginUsuarioOptional = loginUsuarioRepository.findById(id);
        if (loginUsuarioOptional.isPresent()) {
            LoginUsuario login = loginUsuarioOptional.get();
            login.setPassword(novaSenha);
            return loginUsuarioRepository.save(login);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Login de usuário não encontrado com o id, impossível atualizar a senha" + id);
        }
    }
}
