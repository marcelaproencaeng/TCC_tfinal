package com.bluerecycling.bluerecycling.service;

import com.bluerecycling.bluerecycling.dto.LoginDTO;
import com.bluerecycling.bluerecycling.model.Login;
import com.bluerecycling.bluerecycling.repository.LoginRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Login adicionarLogin(LoginDTO loginDTO) {
        Login loginASerAdicionado = new Login();
        loginASerAdicionado.setCnpj(loginDTO.getCnpj());
        loginASerAdicionado.setSenha(loginDTO.getSenha());

        Optional<Login> login = findById(loginASerAdicionado.getId());
        if (login != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login" + login.get().getId()
                    + "já existe!");
        }
        loginRepository.save(loginASerAdicionado);
        return loginASerAdicionado;
    }

    public List<Login> buscarTodos() {
        return loginRepository.findAll();
    }

    public void deletar(Long id) {
        Optional<Login> loginParaRemover = findById(id);
        if (loginParaRemover.isPresent()) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não é possível remover um login por id inexistente");
        }
        loginRepository.delete(loginParaRemover.get());
    }

    private Optional<Login> findById(Long id) {
        return loginRepository.findById(id);
    }

    public Login atualizarLoginPorId(String novaSenha, Long id) {

        Optional<Login> loginOptional = loginRepository.findById(id);
        if (loginOptional.isPresent()) {
            Login login = loginOptional.get();
            login.setSenha(novaSenha);
            return loginRepository.save(login);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Login de usuário não encontrado com o id, impossível atualizar a senha" + id);
        }
    }
}









