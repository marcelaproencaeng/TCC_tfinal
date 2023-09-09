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
    private String UserName;
    @Column
    private String senha;

    public LoginUsuario(){

    }

    public LoginUsuario(Long id, String UserName, String senha) {
        this.id = id;
        this.UserName= UserName;
        this.senha = senha;
    }
}
