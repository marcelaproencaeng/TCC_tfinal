package com.bluerecycling.bluerecycling.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUsuarioDTO {
    private Long id;
    private String cnpj;
    private String senha;


}
