package fundatec.org.bluerecycling.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarUsuarioDTO {
    private String razaoSocial;
    private String userName;
    private String cnpj;
    private String residuoDeInteresse;
    private String transporte;

}
