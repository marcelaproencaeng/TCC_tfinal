package fundatec.org.bluerecycling.dto;

import fundatec.org.bluerecycling.model.Compra;
import fundatec.org.bluerecycling.model.Residuo;
import fundatec.org.bluerecycling.model.Usuario;
import fundatec.org.bluerecycling.model.enuns.TipoResiduo;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class CriarCompraDTO {
    private List<CriarResiduoDTO> residuos;
    private String Username;
    private BigDecimal valor;
    private Integer quantidade;
    private TipoResiduo classificacao;
    private List<Usuario> usuarios;


}
