package fundatec.org.bluerecycling.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarLoginUsuarioDTO {
    private String Username;
    private String senha;
}

