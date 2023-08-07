package com.bluerecycling.bluerecycling.dto;

import com.bluerecycling.bluerecycling.model.Usuario;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CadastroDTO {

    private Long idCadastro;

    private String Cnpj;

    private String senha;

    private List<Usuario> usuarios;
}
