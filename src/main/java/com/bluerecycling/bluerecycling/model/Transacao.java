package com.bluerecycling.bluerecycling.model;

import com.bluerecycling.bluerecycling.model.enuns.TipoNicho;
import com.bluerecycling.bluerecycling.model.enuns.TipoTransacao;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_transacao")
@Data
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idTransacao;
    @Column
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;
    @Column
    private BigDecimal valor;
    private Boolean hasMaisDeDoisUsuarios;
    @Column
    private Boolean hasMaisDeUmResiduo;
//    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "transacao_id")
    private NotaFiscal nota;
//    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "transacao_id")
    List<Usuario> usuarios;
    @Column
    @Enumerated(EnumType.STRING)
    private TipoNicho nicho;
    @Column
    @Temporal(TemporalType.TIME)
    private LocalDateTime entrada;
    @Column
    @Temporal(TemporalType.TIME)
    private LocalDateTime saida;
    @Column
    private List<Residuo> residuos;
    @Column
    @OneToOne(mappedBy = "transacao")
    private Intermediacao intermediacao;


}
