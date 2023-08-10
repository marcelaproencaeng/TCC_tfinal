//package com.bluerecycling.bluerecycling.ctrl;
//
//import com.bluerecycling.bluerecycling.dto.CadastroDTO;
//import com.bluerecycling.bluerecycling.model.Cadastro;
//import com.bluerecycling.bluerecycling.service.CadastroService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/cadastros")
//@CrossOrigin(origins = "*")
//public class CadastroCtrl {
//    private CadastroService cadastroService;
//
//    public CadastroCtrl(CadastroService cadastroService) {
//
//        this.cadastroService = cadastroService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Cadastro> create(@RequestBody CadastroDTO cadastroDTO) {
//        System.out.println("Inserindo o cadastro:" + cadastroDTO.getCnpj());
//        Cadastro cadastro = cadastroService.adicionarCadastro(cadastroDTO);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Cadastro>> buscarTodos() {
//        return ResponseEntity.ok((List<Cadastro>) this.cadastroService.buscarTodos());
//    }
//
//    @DeleteMapping("/{cnpj}")
//    public void deletarUsuarioPorCnpj(@PathVariable("cnpj") String cnpj) {
//        this.cadastroService.deletar(cnpj);
//    }
//
//    @PutMapping("/{idCadastro}/{senha}")
//    public ResponseEntity<Cadastro> atualizarSenhaDeCadastroPorId(@PathVariable("idCadastro") Long idCadastro,
//                                                                  @PathVariable("sobrenome") String senha) {
//        cadastroService.atualizarSenhaPorId(senha, idCadastro);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//}
