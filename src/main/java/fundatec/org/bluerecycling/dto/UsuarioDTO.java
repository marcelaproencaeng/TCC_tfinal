package fundatec.org.bluerecycling.dto;


import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class UsuarioDTO {

//    private Long idUsuario;
    private Long idUsuario;
    private String razaoSocial;
    private Boolean hasCnpj;
    private String userName;
    private String cnpj;
    private String nome;
    private Boolean hasResiduoDeInteresse;
    private Boolean isVendedor;
    private Boolean hasTransporte;
    private String email;


}
