//package fundatec.org.bluerecycling.ctrl;
//
//import fundatec.org.bluerecycling.dto.ConsultaCepUsuarioRequestDTO;
//import fundatec.org.bluerecycling.dto.ConsultaCnpjUsuarioRequestDTO;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//@RequestMapping("consulta-cnpjusuarios")
//@CrossOrigin(origins = "*")
//public class ConsultaCnpjUsuarioController {
//    @GetMapping("/{cnpj}")
//    public ConsultaCnpjUsuarioRequestDTO consultaCnpjUsuario(@PathVariable("cnpj") String cnpj) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<ConsultaCnpjUsuarioRequestDTO> resp =
//                restTemplate.getForEntity(
//                        String.format(
//                                "https://www.receitaws.com.br/v1/%s/json", cnpj),
//                        ConsultaCnpjUsuarioRequestDTO.class);
//        return resp.getBody();
//    }
//}
