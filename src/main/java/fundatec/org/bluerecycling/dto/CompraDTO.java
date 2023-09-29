package fundatec.org.bluerecycling.dto;

import fundatec.org.bluerecycling.model.Compra;
import fundatec.org.bluerecycling.model.Usuario;
import fundatec.org.bluerecycling.model.enuns.TipoResiduo;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class CompraDTO {

    private Long idCompra;
    private List<Compra> residuos;
    private BigDecimal valor;
    private Integer quantidade;
    private TipoResiduo classificacao;
    private List<Usuario> usuarios;
}
