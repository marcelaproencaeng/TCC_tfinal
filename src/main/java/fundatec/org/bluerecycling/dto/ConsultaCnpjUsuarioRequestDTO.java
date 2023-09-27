package fundatec.org.bluerecycling.dto;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ConsultaCnpjUsuarioRequestDTO {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String status;
    private String cnaePrincipalDescricao;
    private String cnaePrincipalCodigo;
    private String cep;
    private String dataAbertura;
    private String ddd;
    private String telefone;
    private String email;
    private String tipoLogradouro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;

}
