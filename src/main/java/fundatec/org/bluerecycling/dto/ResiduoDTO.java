package fundatec.org.bluerecycling.dto;



import fundatec.org.bluerecycling.model.enuns.TipoNicho;
import fundatec.org.bluerecycling.model.enuns.TipoResiduo;
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
}
