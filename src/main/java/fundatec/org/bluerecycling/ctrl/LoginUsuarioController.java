package fundatec.org.bluerecycling.ctrl;

import fundatec.org.bluerecycling.dto.CriarLoginUsuarioDTO;
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
public class LoginUsuarioController {
    private LoginUsuarioService loginUsuarioService;

    public LoginUsuarioController(LoginUsuarioService loginUsuarioService) {
        this.loginUsuarioService = loginUsuarioService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CriarLoginUsuarioDTO criarLoginUsuarioDTO) {
        System.out.println("inserindo login" + criarLoginUsuarioDTO.getUserName());
        String login = loginUsuarioService.adicionarLogin(criarLoginUsuarioDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
//        return ResponseEntity.ok("Login: " + login);
    }

    @GetMapping
    public ResponseEntity<List<LoginUsuario>> buscarTodos() {
        List<LoginUsuario> login = loginUsuarioService.buscarTodos();
        return ResponseEntity.ok((List<LoginUsuario>) this.loginUsuarioService.buscarTodos());

    }

    @DeleteMapping("/{userName}")
    public void deletarLoginPorUserName(@PathVariable("userName") String userName) {
        this.loginUsuarioService.deletar(userName);
    }

    @PutMapping("/{id}/{senha}")
    public ResponseEntity<LoginUsuario> atualizarSenhaDeLoginPorId(@PathVariable("id") Long id,
                                                                   @PathVariable("senha") String senha) {
        loginUsuarioService.atualizarLoginPorId(senha, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
