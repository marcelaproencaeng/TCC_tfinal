package fundatec.org.bluerecycling.ctrl;

import fundatec.org.bluerecycling.dto.LoginUsuarioDTO;
import fundatec.org.bluerecycling.model.LoginUsuarioModel;
import fundatec.org.bluerecycling.service.LoginUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/logins")
@CrossOrigin(origins = "*")
public class LoginUsuarioCTRL {
    private LoginUsuarioService loginUsuarioService;

    public LoginUsuarioCTRL(LoginUsuarioService loginUsuarioService) {
        this.loginUsuarioService = loginUsuarioService;
    }

    @PostMapping
    public ResponseEntity<LoginUsuarioModel> create(@RequestBody LoginUsuarioDTO loginDTO) {
//        System.out.println("inserindo login" + loginDTO.getIdLogin());
        System.out.println("Inserindo login....");
        LoginUsuarioModel login = loginUsuarioService.adicionarLogin(loginDTO);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
