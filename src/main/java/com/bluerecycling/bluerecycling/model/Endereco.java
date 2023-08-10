//package com.bluerecycling.bluerecycling.model;
//
//import jakarta.persistence.*;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import lombok.Data;
//
//@Entity
//@Table(name = "tb_endereco")
//@Data
//public class Endereco {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column
//    private Long idEndereco;
//    @OneToOne
//    @JoinColumn(name = "id_endereco")
//    private Usuario usuario;
//    @Column
//    private String Rua;
//    @Column
//    private Integer cep;
//    @Column
//    private Integer numero;
//    @Column
//    private String bairro;
//    @Column
////    Poderia ser um Enum
//    private String cidade;
//    @Column
//    private String estado;
//    @Column
//    private String pais;
//}
