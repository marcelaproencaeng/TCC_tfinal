package fundatec.org.bluerecycling.ctrl;

import fundatec.org.bluerecycling.dto.UsuarioDTO;
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
//     private PokemonIntegrationService pokemonIntegrationService;
//
//    public PokemonController(PokemonIntegrationService pokemonIntegrationService) {
//        this.pokemonIntegrationService = pokemonIntegrationService;
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<PokemonResponse> findById(@PathVariable("id") int id) {
//        return ResponseEntity.ok(this.pokemonIntegrationService.findById(id));
//    }
//
//    @GetMapping("/name/{name}")
//    public ResponseEntity<PokemonResponse> findByName(@PathVariable("name") String name) {
//        return ResponseEntity.ok(this.pokemonIntegrationService.findByName(name));
//    }
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
