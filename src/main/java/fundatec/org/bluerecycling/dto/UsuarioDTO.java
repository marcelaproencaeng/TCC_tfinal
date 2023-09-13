package fundatec.org.bluerecycling.dto;

//import fundatec.org.bluerecycling.model.Contato;
//import fundatec.org.bluerecycling.model.Endereco;
//import fundatec.org.bluerecycling.model.Plano;
import fundatec.org.bluerecycling.model.Residuo;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class UsuarioDTO {

    private Long idUsuario;
    private String razaoSocial;
//    private Endereco endereco;
//    private Contato contato;
    private Boolean hasCnpj;

    private String userName;
    private String cnpj;
    private String nome;
//    private List<Residuo> residuos;
//    private Plano plano;
    private Boolean hasResiduoDeInteresse;
    private Boolean isVendedor;
    private Boolean hasTransporte;
    private String email;

}
