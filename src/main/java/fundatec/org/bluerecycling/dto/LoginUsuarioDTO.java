package fundatec.org.bluerecycling.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUsuarioDTO {
    private Long idLogin;
    private String cnpj;
    private String senha;
}
