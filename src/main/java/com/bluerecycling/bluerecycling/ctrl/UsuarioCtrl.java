//package com.bluerecycling.bluerecycling.ctrl;
//
//import com.bluerecycling.bluerecycling.dto.CadastroDTO;
//import com.bluerecycling.bluerecycling.dto.UsuarioDTO;
//import com.bluerecycling.bluerecycling.model.Cadastro;
//import com.bluerecycling.bluerecycling.model.Plano;
//import com.bluerecycling.bluerecycling.model.Residuo;
//import com.bluerecycling.bluerecycling.model.Usuario;
//import com.bluerecycling.bluerecycling.service.UsuarioService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/usuarios")
//@CrossOrigin(origins = "*")
//public class UsuarioCtrl {
//    private UsuarioService usuarioService;
//
//    public UsuarioCtrl(UsuarioService usuarioService) {
//        this.usuarioService = usuarioService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Usuario> create(@RequestBody UsuarioDTO usuarioDTO) {
//        System.out.println("Inserindo o cadastro:" + usuarioDTO.getRazaoSocial());
//        Usuario usuario = usuarioService.adicionarUsuario(usuarioDTO);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//    @GetMapping
//    public ResponseEntity<List<Usuario>> buscarTodos() {
//        return ResponseEntity.ok((List<Usuario>) this.usuarioService.buscarTodos());
//    }
//    @DeleteMapping("/{razaoSocial}")
//    public void deletarUsuarioPorRazaoSocial(@PathVariable("razao social") String razaoSocial) {
//
//        this.usuarioService.deletar(razaoSocial);
//    }
//    @PutMapping("/{idUsuario}/{plano}")
//    public ResponseEntity<Residuo> atualizarUsuarioPorPlano(@PathVariable("idUsuario") Long idUsuario,
//                                                                @PathVariable("plano") Plano plano) {
//        usuarioService.atualizarUsuarioPorPlano(plano, idUsuario);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//
//}
