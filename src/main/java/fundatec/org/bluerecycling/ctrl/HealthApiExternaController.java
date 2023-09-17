package fundatec.org.bluerecycling.ctrl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health-apiExterna")
@CrossOrigin(origins = "*")
public class HealthApiExternaController {
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Requisição de teste para API externa de consulta de ceps do bluerecycling");
    }
}
