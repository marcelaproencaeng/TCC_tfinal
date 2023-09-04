package fundatec.org.bluerecycling.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_login")
@Data
public class LoginUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String cnpj;
    @Column
    private String senha;

    public LoginUsuario(){

    }

    public LoginUsuario(Long id, String cnpj, String senha) {
        this.id = id;
        this.cnpj = cnpj;
        this.senha = senha;
    }
}
