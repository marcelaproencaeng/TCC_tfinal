//package com.bluerecycling.bluerecycling.ctrl;
//
//import com.bluerecycling.bluerecycling.dto.PlanoDTO;
//import com.bluerecycling.bluerecycling.model.Plano;
//import com.bluerecycling.bluerecycling.model.Usuario;
//import com.bluerecycling.bluerecycling.service.PlanoService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/logins")
//@CrossOrigin(origins = "*")
//public class PlanoCtrl {
//    private PlanoService planoService;
//
//    public PlanoCtrl(PlanoService planoService) {
//        this.planoService = planoService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Usuario> create(@RequestBody PlanoDTO planoDTO) {
//        System.out.println("Inserindo o plano:" + planoDTO.getIdPlano());
//        Plano plano = planoService.adicionarPlano(planoDTO);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Plano>> buscarTodos() {
//        return ResponseEntity.ok((List<Plano>) this.planoService.buscarTodos());
//    }
//
//    @DeleteMapping("/{assinante}")
//    public void deletarPlanoPorAssinante(@PathVariable("assinante") Usuario assinante) {
//
//        this.planoService.deletar(assinante);
//    }
//
//    @PutMapping("/{idPlano}/{valor}")
//    public ResponseEntity<Plano> atualizarPlanoDeUsuarioPorValor(@PathVariable("idPlano") Long idPlano,
//                                                                     @PathVariable("valor") Double valor) {
//        planoService.atualizarPlanoPorValor(idPlano, valor);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//}
