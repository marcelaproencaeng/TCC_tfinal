package com.bluerecycling.bluerecycling.ctrl;

import com.bluerecycling.bluerecycling.dto.TransporteDTO;
import com.bluerecycling.bluerecycling.dto.UsuarioDTO;
import com.bluerecycling.bluerecycling.model.Transporte;
import com.bluerecycling.bluerecycling.model.Usuario;
import com.bluerecycling.bluerecycling.service.ResiduoService;
import com.bluerecycling.bluerecycling.service.TransporteService;
import com.bluerecycling.bluerecycling.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/transportes")
@CrossOrigin(origins = "*")
public class TransporteCtrl {
    private final TransporteService transporteService;
    private final ResiduoService residuoService;

    public TransporteCtrl(TransporteService transporteService, ResiduoService residuoService) {
        this.transporteService = transporteService;
        this.residuoService = residuoService;
    }
    @PostMapping
    public ResponseEntity<Transporte> create(@RequestBody TransporteDTO transporteDTO) {
        System.out.println("Inserindo o transporte:" + transporteDTO.getHasLicença());
        Transporte transporte = transporteService.adicionarTransporte(transporteDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
