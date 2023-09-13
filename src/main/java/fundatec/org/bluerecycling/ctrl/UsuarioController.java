package fundatec.org.bluerecycling.ctrl;

import fundatec.org.bluerecycling.dto.UsuarioDTO;
import fundatec.org.bluerecycling.model.Residuo;
import fundatec.org.bluerecycling.model.Usuario;
import fundatec.org.bluerecycling.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody UsuarioDTO usuarioDTO) {
        System.out.println("Inserindo o usuário:" + usuarioDTO.getRazaoSocial());
        Usuario usuario = usuarioService.adicionarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.ok((List<Usuario>) this.usuarioService.buscarTodos());
    }
}
