package com.bluerecycling.bluerecycling.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_intermediacao")
@Data
public class Intermediacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idIntermediacao;
    @Column
    private BigDecimal valorIntermediacao;
    @Column
    @JoinColumn(name = "id_transacao")
    private List<Transacao> transacoes;
    @Column
    private Usuario usuario;

//    @Column
//    @Enumerated(EnumType.STRING)
//    private NotaFiscal nota;
}
