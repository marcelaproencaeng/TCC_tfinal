package com.bluerecycling.bluerecycling.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_login")
@Data
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String cnpj;
    @Column
    private String senha;
}
