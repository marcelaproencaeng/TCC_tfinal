package fundatec.org.bluerecycling.dto;

import fundatec.org.bluerecycling.model.Usuario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUsuarioDTO {
    private Long idLogin;
    private String userName;
    private String senha;
//    private Usuario usuario;
}
