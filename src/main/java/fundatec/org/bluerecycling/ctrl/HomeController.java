//package fundatec.org.bluerecycling.ctrl;
//
//import fundatec.org.bluerecycling.dto.CriarLoginUsuarioDTO;
//import fundatec.org.bluerecycling.dto.HomeDTO;
//import fundatec.org.bluerecycling.model.Home;
//import fundatec.org.bluerecycling.model.LoginUsuario;
//import fundatec.org.bluerecycling.service.HomeService;
//import fundatec.org.bluerecycling.service.LoginUsuarioService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//public class HomeController {
//
//    private HomeService homeService;
//
//    public HomeController(HomeService homeService) {
//        this.homeService = homeService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Home> create(@RequestBody HomeDTO homeDTO) {
//        System.out.println("inserindo resíduo" + homeDTO.getUserName());
//        Home home = homeService.adicionarLogin(criarLoginUsuarioDTO);
//        return ResponseEntity.status(HttpStatus.OK).build();
////        return ResponseEntity.ok("Login: " + login);
//    }
//}
