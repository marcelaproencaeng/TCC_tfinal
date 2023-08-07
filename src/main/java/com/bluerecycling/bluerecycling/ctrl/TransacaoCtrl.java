package com.bluerecycling.bluerecycling.ctrl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transacoes")
@CrossOrigin(origins = "*")
public class TransacaoCtrl {
}
