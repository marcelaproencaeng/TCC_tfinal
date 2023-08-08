package com.bluerecycling.bluerecycling.dto;

import com.bluerecycling.bluerecycling.model.enuns.TipoNicho;
import com.bluerecycling.bluerecycling.model.enuns.TipoResiduo;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CriarResiduoDTO {
    private String nome;
    private Double quantidade;
    private BigDecimal valor;
    private TipoResiduo classificacao;
    private TipoNicho nicho;
}
