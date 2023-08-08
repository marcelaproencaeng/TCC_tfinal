package com.bluerecycling.bluerecycling.dto;

import com.bluerecycling.bluerecycling.model.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarUsuarioDTO {

//    private Long idUsuario;
//    private String razaoSocial;
//    private Endereco endereco;
//    private Contato contato;
//    private String cnpj;
//    private String nome;
    private Residuo residuo;
    private Plano plano;
//    private String login;
    private Boolean isVendedor;
    private Boolean hasTransporte;
//    private String email;
    private Cadastro cadastro;
}
