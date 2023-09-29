package fundatec.org.bluerecycling.ctrl;

import fundatec.org.bluerecycling.dto.CriarCompraDTO;
import fundatec.org.bluerecycling.dto.CriarResiduoDTO;
import fundatec.org.bluerecycling.model.Compra;
import fundatec.org.bluerecycling.model.Residuo;
import fundatec.org.bluerecycling.service.CompraService;
import fundatec.org.bluerecycling.service.ResiduoService;
import fundatec.org.bluerecycling.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/compras")
@CrossOrigin(origins = "*")
public class CompraController {
    private final CompraService compraService;
    private final UsuarioService usuarioService;

    public CompraController(CompraService compraService, UsuarioService usuarioService) {
        this.compraService = compraService;
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody CriarCompraDTO criarCompraDTO) {
        System.out.println("Cadastrando compra:" + criarCompraDTO.getValor());
        BigDecimal valorTotalCompra = compraService.adicionarCompra(criarCompraDTO);
//        return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.ok("Valor total da compra:R$"+ valorTotalCompra);
    }


}

