package com.bluerecycling.bluerecycling.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CriarTransacaoDTO {
    private String razaoSocial;
    //     private String userName;
    private List<CriarResiduoDTO> residuos;
    private List<CriarUsuarioDTO> usuarios;
}
