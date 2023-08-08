package com.bluerecycling.bluerecycling.ctrl;

import com.bluerecycling.bluerecycling.dto.LoginDTO;
import com.bluerecycling.bluerecycling.model.Login;
import com.bluerecycling.bluerecycling.service.LoginService;
import com.bluerecycling.bluerecycling.service.ResiduoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/logins")
@CrossOrigin(origins = "*")
public class LoginCtrl {

    private LoginService loginService;

    public LoginCtrl(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<Login> create(@RequestBody LoginDTO loginDTO) {
        System.out.println("inserindo login" + loginDTO.getIdLogin());
        Login login = loginService.adicionarLogin(loginDTO);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @GetMapping
    public ResponseEntity<List<Login>> buscarTodos() {
        List<Login> login = loginService.buscarTodos();
        return ResponseEntity.ok((List<Login>) this.loginService.buscarTodos());

    }

    @DeleteMapping("/{id}")
    public void deletarLoginPorId(@PathVariable("id") Long id) {
        this.loginService.deletar(id);
    }

    @PutMapping("/{id}/{senha}")
    public ResponseEntity<Login> atualizarSenhaDeLoginPorId(@PathVariable("id") Long id,
                                                            @PathVariable("senha") String senha) {
        loginService.atualizarLoginPorId(senha,id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
