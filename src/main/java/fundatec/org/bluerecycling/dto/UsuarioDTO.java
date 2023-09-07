package fundatec.org.bluerecycling.dto;

import fundatec.org.bluerecycling.model.Contato;
import fundatec.org.bluerecycling.model.Endereco;
import fundatec.org.bluerecycling.model.Plano;
import fundatec.org.bluerecycling.model.Residuo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {

    private Long idUsuario;
    private String razaoSocial;
    private Endereco endereco;
    private Contato contato;
    private Boolean hasCnpj;
    private String cnpj;
    private String nome;
    private Residuo residuo;
    private Plano plano;
    private String login;
    private Boolean hasResiduo;
    private Boolean isVendedor;
    private Boolean hasTransporte;
    private String email;

}
