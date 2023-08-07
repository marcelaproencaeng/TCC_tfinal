package com.bluerecycling.bluerecycling.service;

import com.bluerecycling.bluerecycling.dto.UsuarioDTO;
import com.bluerecycling.bluerecycling.model.Plano;
import com.bluerecycling.bluerecycling.model.Residuo;
import com.bluerecycling.bluerecycling.model.Usuario;
import com.bluerecycling.bluerecycling.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
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
        Usuario usuarioASerAdicionado = new Usuario();

        usuarioASerAdicionado.setIdUsuario(usuarioDTO.getIdUsuario());
        usuarioASerAdicionado.setHaveTransporte(usuarioDTO.getHaveTransporte());
        usuarioASerAdicionado.setIsVendedor(usuarioDTO.getIsVendedor());
        usuarioASerAdicionado.setPlano(usuarioDTO.getPlano());
        usuarioASerAdicionado.setResiduo(usuarioDTO.getResiduo());

        Optional<Usuario> usuario = findById(usuarioASerAdicionado.getIdUsuario());
        if (usuario.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Usuário" + usuario.get().getIdUsuario() + "Já existe");
        }
        return usuarioRepository.save(usuarioASerAdicionado);
    }

    public Optional<Usuario> findById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);

    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public void deletar(String razaoSocial) {
        Usuario usuarioParaRemover = findByRazaoSocial(razaoSocial);
        if (usuarioParaRemover == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não é possível remover usuário inexistente");
        }
        usuarioRepository.delete(usuarioParaRemover);
    }

    public Usuario findByRazaoSocial(String razaoSocial) {

            return usuarioRepository.findByRazaoSocial(razaoSocial);
        }


    public Usuario atualizarPlanoPorId(Plano novoPlano, Long idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setPlano(novoPlano);
            return usuarioRepository.save(usuario);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Usuário não encontrado com o id" + idUsuario);
        }
    }
}


