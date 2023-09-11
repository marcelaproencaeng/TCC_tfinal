package fundatec.org.bluerecycling.model;

import fundatec.org.bluerecycling.model.enuns.TipoNicho;
import fundatec.org.bluerecycling.model.enuns.TipoResiduo;
import jakarta.persistence.*;
import lombok.Data;
//import lombok.*;
import java.math.BigDecimal;
import java.util.List;


//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode
//@ToString
@Entity
@Table(name = "tb_residuo")
@Data
public class Residuo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long idResiduo;
    @Column(name="nome")
    private String nome;
    @Column(name="classificação_tipo_residuo")
    @Enumerated(EnumType.STRING)
    private TipoResiduo classificacao;
    @JoinColumn(name = "id_residuo")
    @Column(name="nicho")
    @Enumerated(EnumType.STRING)
    private TipoNicho nicho;
    @Column(name="quantidade")
    private Double quantidade;
    @Column(name="valor")
    private BigDecimal valor;
    @ManyToMany(mappedBy = "residuos")
    private List<Usuario> usuarios;

    public Residuo() {

    }
    public Residuo(Long idResiduo, String nome,
                   TipoResiduo classificacao, TipoNicho nicho,
                   Double quantidade, BigDecimal valor, List<Usuario> usuarios) {
        this.idResiduo = idResiduo;
        this.nome = nome;
        this.classificacao = classificacao;
        this.nicho = nicho;
        this.quantidade = quantidade;
        this.valor = valor;
        this.usuarios = usuarios;
    }
}

