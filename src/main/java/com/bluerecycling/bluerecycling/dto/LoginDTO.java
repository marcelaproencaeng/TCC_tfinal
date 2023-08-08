package com.bluerecycling.bluerecycling.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDTO {
    private Long idLogin;
    private String cnpj;
    private String senha;


}
