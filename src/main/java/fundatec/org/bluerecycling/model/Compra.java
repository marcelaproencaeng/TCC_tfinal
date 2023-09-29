package fundatec.org.bluerecycling.model;

import fundatec.org.bluerecycling.model.enuns.TipoResiduo;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_compra")
@Data
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idCompra;
    @Column
    private List<Residuo> residuos;
    @Column
    private BigDecimal valor;
    @Column
    private Integer quantidade;
    @Column
    private TipoResiduo classificacao;
    @Column
    private List<Usuario> usuarios;
}
