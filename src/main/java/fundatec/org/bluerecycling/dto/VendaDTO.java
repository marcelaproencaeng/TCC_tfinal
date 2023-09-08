package fundatec.org.bluerecycling.dto;

import fundatec.org.bluerecycling.model.Residuo;
import fundatec.org.bluerecycling.model.Usuario;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class VendaDTO {
    private BigDecimal valor;
    private List<Residuo> residuos;
    private List<Usuario>usuarios;
}
