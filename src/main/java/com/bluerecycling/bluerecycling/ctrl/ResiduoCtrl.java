//package com.bluerecycling.bluerecycling.ctrl;
//
//import com.bluerecycling.bluerecycling.dto.CadastroDTO;
//import com.bluerecycling.bluerecycling.dto.ResiduoDTO;
//import com.bluerecycling.bluerecycling.model.Cadastro;
//import com.bluerecycling.bluerecycling.model.Residuo;
//import com.bluerecycling.bluerecycling.service.ResiduoService;
//import com.bluerecycling.bluerecycling.service.UsuarioService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/residuos")
//@CrossOrigin(origins = "*")
//public class ResiduoCtrl {
//
//    private ResiduoService residuoService;
//
//    public ResiduoCtrl(ResiduoService residuoService) {
//        this.residuoService = residuoService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Residuo> create(@RequestBody ResiduoDTO residuoDTO) {
//        System.out.println("Inserindo o cadastro:" + residuoDTO.getNome());
//        Residuo residuo = residuoService.adicionarResiduo(residuoDTO);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Residuo>> buscarTodos() {
//        return ResponseEntity.ok((List<Residuo>) this.residuoService.buscarTodos());
//    }
//
//    @DeleteMapping("/{nome}")
//    public void deletarResiduoPorNome(@PathVariable("nome") String nome) {
//
//        this.residuoService.deletar(nome);
//    }
//
//    @PutMapping("/{idResiduo}/{quantidade}")
//    public ResponseEntity<Residuo> atualizarQuantidadeDeResiduoPorId(@PathVariable("idResiduo") Long idResiduo,
//                                                                     @PathVariable("quantidade") Double quantidade) {
//        residuoService.atualizarQuantidadePorId(quantidade, idResiduo);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//
//}
