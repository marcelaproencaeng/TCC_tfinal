package fundatec.org.bluerecycling.ctrl;


import fundatec.org.bluerecycling.dto.ConsultaCnpjUsuarioRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("consulta-cnpjusuarios")
@CrossOrigin(origins = "*")
public class ConsultaCnpjUsuarioController {
    @GetMapping("/{cnpj}")
    public ConsultaCnpjUsuarioRequestDTO consultaCnpjUsuario(@PathVariable("cnpj") String cnpj) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ConsultaCnpjUsuarioRequestDTO> resp =
                restTemplate.getForEntity(
                        String.format(
                                "https://api-publica.speedio.com.br/cnpj/{cnpj}", cnpj),
                        ConsultaCnpjUsuarioRequestDTO.class);
        return resp.getBody();

    }
}
//       @GetMapping("/{cnpj}")
//    public ConsultaCnpjUsuarioRequestDTO consultaCnpjUsuario(@PathVariable("cnpj") String cnpj) {
//        RestTemplate restTemplate = new RestTemplate();
//        String apiUrl = "https://api-publica.speedio.com.br/v1/cnpj/{cnpj}";
//
//        ResponseEntity<ConsultaCnpjUsuarioRequestDTO> resp = restTemplate.getForEntity(
//            apiUrl, ConsultaCnpjUsuarioRequestDTO.class, cnpj);
//
//        return resp.getBody();
//    }
//}

//https://receitaws.com.br/v1/cnpj/{cnpj}
//https://www.receitaws.com.br/v1
//https://apiconsultacnpj.com.br/
//https://api-publica.speedio.com.br
//1e967568b3215cd86650437bdb8b56701d9947b2ccf0a08d555095188981590c
