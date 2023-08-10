//package com.bluerecycling.bluerecycling.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.server.ResponseStatusException;
//
//@Entity
//@Table(name = "tb_usuario")
//@Data
//public class Usuario {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column
//    private Long idUsuario;
//    @Column
//    private String razaoSocial;
//    @OneToOne(mappedBy = "cliente")
//    private Endereco endereco;
//    @Column
//    private Contato contato;
//    @Column
//    private String cnpj;
//    @Column
//    private String nome;
//    @Column
//    private Residuo residuo;
//    //    @OneToMany(mappedBy = "assinante")
//    @OneToOne(mappedBy = "assinante")
//    private Plano plano;
//    @Column
//    private String login;
//    @Column
//    private Boolean isVendedor;
//    @Column
//    private Boolean hasTransporte;
//    @Column
//    private String email;
//    @OneToOne
//    @JoinColumn(name = "id_cadastro")
//    private Cadastro cadastro;
//
//    public Boolean hasCNPJ(Usuario usuario) {
//        if (usuario.hasCNPJ(usuario) == false) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                    "Sem um cnpj não é possível realizar um cadastro e fazer uma transacao comercial");
//
//        }
//        return true;
//
//    }
//
//    public Boolean hasTransporte(Usuario usuario) {
//        if (usuario.hasTransporte == false) {
//            System.out.println("Solicite um transporte pela plataforma");
//            new ResponseEntity<String>("Solicite um transporte conosco", HttpStatus.ACCEPTED);
//
//        }
//
//        return true;
//    }
//
//}

