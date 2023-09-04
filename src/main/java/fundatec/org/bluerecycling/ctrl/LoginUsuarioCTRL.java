package fundatec.org.bluerecycling.ctrl;

import fundatec.org.bluerecycling.dto.LoginUsuarioDTO;
import fundatec.org.bluerecycling.model.LoginUsuario;
import fundatec.org.bluerecycling.service.LoginUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/logins")
@CrossOrigin(origins = "*")
public class LoginUsuarioCTRL {
    private LoginUsuarioService loginUsuarioService;

    public LoginUsuarioCTRL(LoginUsuarioService loginUsuarioService) {
        this.loginUsuarioService = loginUsuarioService;
    }

    @PostMapping
    public ResponseEntity<LoginUsuario> create(@RequestBody LoginUsuarioDTO loginDTO) {
        System.out.println("inserindo login" + loginDTO.getIdLogin());
        LoginUsuario login = loginUsuarioService.adicionarLogin(loginDTO);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
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
