package com.bluerecycling.bluerecycling.dto;

import com.bluerecycling.bluerecycling.model.Cadastro;
import com.bluerecycling.bluerecycling.model.enuns.TipoNicho;
import com.bluerecycling.bluerecycling.model.enuns.TipoResiduo;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class ResiduoDTO {

    private Long idResiduo;

    private String nome;

    private TipoResiduo classificacao;

    private TipoNicho nicho;

    private Double quantidade;

    private BigDecimal valor;

    private Cadastro cadastro;
}
