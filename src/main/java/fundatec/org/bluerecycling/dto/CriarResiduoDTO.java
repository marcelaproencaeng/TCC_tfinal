package fundatec.org.bluerecycling.dto;

import fundatec.org.bluerecycling.model.Usuario;
import fundatec.org.bluerecycling.model.enuns.TipoResiduo;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class CriarResiduoDTO {
    private String nome;
    private TipoResiduo classificacao;
    private Double quantidade;
    private BigDecimal valor;

}
