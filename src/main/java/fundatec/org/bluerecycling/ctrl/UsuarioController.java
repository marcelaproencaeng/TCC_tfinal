package fundatec.org.bluerecycling.ctrl;

import fundatec.org.bluerecycling.dto.UsuarioDTO;
import fundatec.org.bluerecycling.model.LoginUsuario;
import fundatec.org.bluerecycling.model.Residuo;
import fundatec.org.bluerecycling.model.Usuario;
import fundatec.org.bluerecycling.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
//        String usuario1 = usuarioDTO.getCnpj();
//        LoginUsuario senha = usuarioDTO.;
//
//        if(usuario1.equals("12345678910112") && senha.equals("admin")) {
//            return ResponseEntity.status(HttpStatus.OK).build();
//        } else {
//            return ResponseEntity.status(HttpStatus.OK).build();
//        }

        System.out.println("Inserindo o usuário:" + usuarioDTO.getRazaoSocial());
        Usuario usuario = usuarioService.adicionarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.ok((List<Usuario>) this.usuarioService.buscarTodos());
    }

    @DeleteMapping("/{cnpj}")
    public void deletarUsuarioPorNome(@PathVariable("cnpj") String cnpj) {

        this.usuarioService.deletar(cnpj);
    }

    @PutMapping("/{idUsuario}/{email}")
    public ResponseEntity<Usuario> atualizarEmailDeUsuarioPorId(@PathVariable("idUsuario") Long idUsuario,
                                                                @PathVariable("email") String email) {
        usuarioService.atualizarEmailPorId(email, idUsuario);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
