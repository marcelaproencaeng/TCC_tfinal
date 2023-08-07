package com.bluerecycling.bluerecycling.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@Data
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idCadastro;
    @Column
    private String Cnpj;
    @Column
    private String senha;
    @Column
    @OneToOne(mappedBy = "cadastro")
    private List<Usuario> usuarios;

}
