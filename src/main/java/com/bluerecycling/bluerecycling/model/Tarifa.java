//package com.bluerecycling.bluerecycling.model;
//
//import com.bluerecycling.bluerecycling.model.enuns.TipoPlano;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.math.BigDecimal;
//
//@Entity
//@Table(name = "tb_tarifa")
//@Data
//public class Tarifa {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column
//    private Long idTarifa;
//
//    @Column
//    @Enumerated(EnumType.STRING)
//    private TipoPlano tipoPlano;
//    @Column
//    private BigDecimal valorPago;
//
//}
