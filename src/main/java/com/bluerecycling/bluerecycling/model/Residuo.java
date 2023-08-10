//package com.bluerecycling.bluerecycling.model;
//
//import com.bluerecycling.bluerecycling.model.enuns.TipoNicho;
//import com.bluerecycling.bluerecycling.model.enuns.TipoResiduo;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.math.BigDecimal;
//
//@Entity
//@Table(name = "tb_residuo")
//@Data
//public class Residuo {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column
//    private Long idResiduo;
//    @Column
//    private String nome;
//    @Column
//    @Enumerated(EnumType.STRING)
//    private TipoResiduo classificacao;
//    @JoinColumn(name="id_residuo")
//    @Enumerated(EnumType.STRING)
//    private TipoNicho nicho;
//    @Column
//    private Double quantidade;
//    @Column
//    private BigDecimal valor;
//    @Column
//    private Cadastro cadastro;
//
//}
