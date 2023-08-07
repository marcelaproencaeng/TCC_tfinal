package com.bluerecycling.bluerecycling.ctrl;

import com.bluerecycling.bluerecycling.service.UsuarioService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioCtrl {
    private UsuarioService usuarioService;

    public UsuarioCtrl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

}
