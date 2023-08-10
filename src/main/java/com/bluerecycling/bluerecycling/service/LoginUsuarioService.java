package com.bluerecycling.bluerecycling.service;

import com.bluerecycling.bluerecycling.dto.LoginUsuarioDTO;
import com.bluerecycling.bluerecycling.model.LoginUsuario;
import com.bluerecycling.bluerecycling.repository.LoginUsuarioRepository;
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

        Optional<LoginUsuario> login = findById(loginASerAdicionado.getId());
        if (login.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login" + login.get().getId()
                    + "já existe!");
        }
        loginUsuarioRepository.save(loginASerAdicionado);
        return loginASerAdicionado;
    }

    public List<LoginUsuario> buscarTodos() {
        return loginUsuarioRepository.findAll();
    }

    public void deletar(Long id) {
        Optional<LoginUsuario> loginParaRemover = findById(id);
        if (loginParaRemover.isPresent()) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não é possível remover um login por id inexistente");
        }
        loginUsuarioRepository.delete(loginParaRemover.get());
    }

    private Optional<LoginUsuario> findById(Long id) {
        return loginUsuarioRepository.findById(id);
    }

    public LoginUsuario atualizarLoginPorId(String novaSenha, Long id) {

        Optional<LoginUsuario> loginOptional = loginUsuarioRepository.findById(id);
        if (loginOptional.isPresent()) {
            LoginUsuario login = loginOptional.get();
            login.setSenha(novaSenha);
            return loginUsuarioRepository.save(login);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Login de usuário não encontrado com o id, impossível atualizar a senha" + id);
        }
    }
}









