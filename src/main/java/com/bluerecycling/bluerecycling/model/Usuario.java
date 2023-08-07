package com.bluerecycling.bluerecycling.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idUsuario;
    @Column
    private String razaoSocial;
    @OneToOne(mappedBy = "cliente")
    private Endereco endereco;
    @Column
    private Contato contato;
    @Column
    private String cnpj;
    @Column
    private String nome;
    @Column
    private Residuo residuo;
//    @OneToMany(mappedBy = "assinante")
    @OneToOne(mappedBy = "assinante")
    private Plano plano;
    @Column
    private String login;
    @Column
    private Boolean isVendedor;
    @Column
    private Boolean haveTransporte;
    @Column
    private String email;
    @OneToOne
    @JoinColumn(name = "id_cadastro")
    private Cadastro cadastro;
}
