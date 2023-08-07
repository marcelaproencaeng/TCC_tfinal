package com.bluerecycling.bluerecycling.ctrl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health")
@CrossOrigin(origins = "*")
public class HealthCtrl {
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Requisição de teste para API do bluerecycling");
    }
}
