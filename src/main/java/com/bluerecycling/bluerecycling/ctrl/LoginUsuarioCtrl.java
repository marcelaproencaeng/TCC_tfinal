package com.bluerecycling.bluerecycling.ctrl;

import com.bluerecycling.bluerecycling.dto.LoginUsuarioDTO;
import com.bluerecycling.bluerecycling.model.LoginUsuario;
import com.bluerecycling.bluerecycling.service.LoginUsuarioService;
//import com.bluerecycling.bluerecycling.service.ResiduoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;

import java.util.List;
//import java.util.Optional;

@RestController
@RequestMapping("api/v1/logins")
@CrossOrigin(origins = "*")
public class LoginUsuarioCtrl {

    private LoginUsuarioService loginUsuarioService;

    public LoginUsuarioCtrl(LoginUsuarioService loginUsuarioService) {
        this.loginUsuarioService = loginUsuarioService;
    }

    @PostMapping
    public ResponseEntity<LoginUsuario> create(@RequestBody LoginUsuarioDTO loginDTO) {
        System.out.println("inserindo login" + loginDTO.getId());
        LoginUsuario login = loginUsuarioService.adicionarLogin(loginDTO);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
//    public ResponseEntity<String> login(@RequestBody LoginUsuarioDTO loginUsuarioDTO) {
//        boolean loginSuccessful = loginUsuarioService.verifyLogin(loginUsuarioDTO.getIdLogin(), loginUsuarioDTO.getSenha());
//
//        if (loginSuccessful) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
//        }
//    }

    @GetMapping
    public ResponseEntity<List<LoginUsuario>> buscarTodos() {
        List<LoginUsuario> login = loginUsuarioService.buscarTodos();
        return ResponseEntity.ok((List<LoginUsuario>) this.loginUsuarioService.buscarTodos());

    }

    @DeleteMapping("/{cnpj}")
    public void deletarLoginPorCnpj(@PathVariable("cnpj") String cnpj) {
        this.loginUsuarioService.deletar(cnpj);
    }

    @PutMapping("/{id}/{senha}")
    public ResponseEntity<LoginUsuario> atualizarSenhaDeLoginPorId(@PathVariable("id") Long id,
                                                                   @PathVariable("senha") String senha) {
        loginUsuarioService.atualizarLoginPorId(senha, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
