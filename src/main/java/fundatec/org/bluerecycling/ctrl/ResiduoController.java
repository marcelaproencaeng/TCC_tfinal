package fundatec.org.bluerecycling.ctrl;

import fundatec.org.bluerecycling.dto.ResiduoDTO;
import fundatec.org.bluerecycling.model.Residuo;
import fundatec.org.bluerecycling.service.ResiduoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/residuos")
@CrossOrigin(origins = "*")
public class ResiduoController {

    private ResiduoService residuoService;

    public ResiduoController(ResiduoService residuoService) {
        this.residuoService = residuoService;
    }

    @PostMapping
    public ResponseEntity<Residuo> create(@RequestBody ResiduoDTO residuoDTO) {
        System.out.println("Cadastrando resíduo:" + residuoDTO.getNome());
        Residuo residuo = residuoService.adicionarResiduo(residuoDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<Residuo>> buscarTodos() {
        return ResponseEntity.ok((List<Residuo>) this.residuoService.buscarTodos());
    }

    @DeleteMapping("/{nome}")
    public void deletarResiduoPorNome(@PathVariable("nome") String nome) {

        this.residuoService.deletar(nome);
    }

    @PutMapping("/{idResiduo}/{quantidade}")
    public ResponseEntity<Residuo> atualizarQuantidadeDeResiduoPorId(@PathVariable("idResiduo") Long idResiduo,
                                                                     @PathVariable("quantidade") Double quantidade) {
        residuoService.atualizarQuantidadePorId(quantidade, idResiduo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
