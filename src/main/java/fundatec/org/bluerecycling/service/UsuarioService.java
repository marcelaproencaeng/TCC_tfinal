package fundatec.org.bluerecycling.service;

import fundatec.org.bluerecycling.dto.UsuarioDTO;
import fundatec.org.bluerecycling.model.LoginUsuario;
import fundatec.org.bluerecycling.model.Usuario;
import fundatec.org.bluerecycling.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario adicionarUsuario(UsuarioDTO usuarioDTO) {
//
        Usuario usuarioASerAdicionado = new Usuario();

        usuarioASerAdicionado.setHasTransporte(usuarioDTO.getHasTransporte());
        usuarioASerAdicionado.setIsVendedor(usuarioDTO.getIsVendedor());
//        usuarioASerAdicionado.setPlano(usuarioDTO.getPlano());
        usuarioASerAdicionado.setHasResiduoDeInteresse(usuarioDTO.getHasResiduoDeInteresse());
        usuarioASerAdicionado.setCnpj(usuarioDTO.getCnpj());
        usuarioASerAdicionado.setUserName(usuarioDTO.getUserName());
        usuarioASerAdicionado.setEmail(usuarioDTO.getEmail());
        usuarioASerAdicionado.setRazaoSocial(usuarioDTO.getRazaoSocial());
        usuarioASerAdicionado.setHasCnpj(usuarioDTO.getHasCnpj());
        usuarioASerAdicionado.setIsVendedor(usuarioDTO.getIsVendedor());
        usuarioASerAdicionado.setNome(usuarioDTO.getNome());
//        usuarioASerAdicionado.setResiduos(usuarioDTO.getResiduos());

//        Usuario usuario = findByRazaoSocial(usuarioASerAdicionado.getRazaoSocial());
//        if (usuario != null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                    "Usuário" + usuario.getRazaoSocial() + "Já existe");
//        }
        Usuario usuario = findByUserName(usuarioASerAdicionado.getUserName());
        if (usuario != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario" + usuario.getUserName() + "Já existe!");
        }

        return usuarioRepository.save(usuarioASerAdicionado);

    }

    public Usuario findByUserName(String userName) {
        return usuarioRepository.findByUserName(userName);
    }


    public Usuario findByRazaoSocial(String razaoSocial) {
        return usuarioRepository.findByRazaoSocial(razaoSocial);

    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public void deletar(String cnpj) {
        Usuario usuarioParaRemover = findByCnpj(cnpj);
        if (usuarioParaRemover == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não é possível remover usuário inexistente");
        }
        usuarioRepository.delete(usuarioParaRemover);
    }

    public Usuario findByCnpj(String cnpj) {
        return usuarioRepository.findByCnpj(cnpj);
    }

    public Usuario atualizarEmailPorId(String novoEmail, Long idUsuario) {

        Optional<Usuario> residuoOptional = usuarioRepository.findById(idUsuario);
        if (residuoOptional.isPresent()) {
            Usuario usuario = residuoOptional.get();
            usuario.setEmail(novoEmail);
            return usuarioRepository.save(usuario);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Usuário não encontrado com o id" + idUsuario);
        }
    }
}

