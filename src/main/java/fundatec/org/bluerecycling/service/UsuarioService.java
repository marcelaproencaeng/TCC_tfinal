package fundatec.org.bluerecycling.service;

import fundatec.org.bluerecycling.dto.UsuarioDTO;
import fundatec.org.bluerecycling.model.Usuario;
import fundatec.org.bluerecycling.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario adicionarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioASerAdicionado = new Usuario();

        usuarioASerAdicionado.setIdUsuario(usuarioDTO.getIdUsuario());
        usuarioASerAdicionado.setHasTransporte(usuarioDTO.getHasTransporte());
        usuarioASerAdicionado.setIsVendedor(usuarioDTO.getIsVendedor());
//        usuarioASerAdicionado.setPlano(usuarioDTO.getPlano());
        usuarioASerAdicionado.setCnpj(usuarioDTO.getCnpj());
        usuarioASerAdicionado.setEmail(usuarioDTO.getEmail());
        usuarioASerAdicionado.setRazaoSocial(usuarioDTO.getRazaoSocial());
        usuarioASerAdicionado.setHasCnpj(usuarioDTO.getHasCnpj());
        usuarioASerAdicionado.setIsVendedor(usuarioDTO.getIsVendedor());
        usuarioASerAdicionado.setNome(usuarioDTO.getNome());
        usuarioASerAdicionado.setResiduos(usuarioDTO.getResiduos());

        Usuario usuario = findByRazaoSocial(usuarioASerAdicionado.getRazaoSocial());
        if (usuario != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Usuário" + usuario.getRazaoSocial() + "Já existe");
        }
        return usuarioRepository.save(usuarioASerAdicionado);
    }

    public Usuario findByRazaoSocial(String razaoSocial) {
        return usuarioRepository.findById(razaoSocial);

    }
}

