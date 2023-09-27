package fundatec.org.bluerecycling.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_login")
@Data
public class LoginUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
//    @Column(name = "usuario", length = 255)
//    private Usuario usuario;

    public LoginUsuario() {

    }

    public LoginUsuario(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
//        this.usuario = usuario;
    }
}
