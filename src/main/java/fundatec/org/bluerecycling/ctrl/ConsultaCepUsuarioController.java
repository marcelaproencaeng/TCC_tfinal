package fundatec.org.bluerecycling.ctrl;

import fundatec.org.bluerecycling.dto.ConsultaCepUsuarioRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consultacepusuarios")
@CrossOrigin(origins = "*")
public class ConsultaCepUsuarioController {
    @GetMapping("/{cep}")
    public ConsultaCepUsuarioRequestDTO consultaCepUsuario(@PathVariable("cep") String cep) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ConsultaCepUsuarioRequestDTO> resp =
                restTemplate.getForEntity(
                        String.format(
                                "https://viacep.com.br/ws/%s/json", cep),
                        ConsultaCepUsuarioRequestDTO.class);
        return resp.getBody();
    }
}
