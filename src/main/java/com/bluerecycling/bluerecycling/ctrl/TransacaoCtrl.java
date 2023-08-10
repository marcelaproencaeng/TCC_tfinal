//package com.bluerecycling.bluerecycling.ctrl;
//
//import com.bluerecycling.bluerecycling.dto.CriarTransacaoDTO;
//import com.bluerecycling.bluerecycling.model.Transacao;
//import com.bluerecycling.bluerecycling.service.TransacaoService;
//import com.bluerecycling.bluerecycling.service.UsuarioService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.math.BigDecimal;
//
//@RestController
//@RequestMapping("api/v1/transacoes")
//@CrossOrigin(origins = "*")
//public class TransacaoCtrl {
//    private final TransacaoService transacaoService;
//    private final UsuarioService usuarioService;
//
//    public TransacaoCtrl(TransacaoService transacaoService, UsuarioService usuarioService) {
//        this.transacaoService = transacaoService;
//        this.usuarioService = usuarioService;
//    }
//    @PostMapping
//    public ResponseEntity<String> create(@RequestBody CriarTransacaoDTO criarTransacaoDTO) {
//        BigDecimal valorTotalTransacao = transacaoService.adicionarTransacao(criarTransacaoDTO);
//        return ResponseEntity.ok("Valor total do pedido: R$" + valorTotalTransacao);
//    }
//}
