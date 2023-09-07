package fundatec.org.bluerecycling.model;

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
    private Boolean hasCnpj;
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
    private Boolean hasResiduo;
    @Column
    private Boolean isVendedor;
    @Column
    private Boolean hasTransporte;
    @Column
    private String email;
//    @OneToOne
//    @JoinColumn(name = "id_cadastro")
//    private Cadastro cadastro;

    public Usuario() {

    }

    public Usuario(Long idUsuario, String razaoSocial, Endereco endereco,
                   Contato contato, Boolean hasCnpj, String cnpj, String nome,
                   Residuo residuo, Plano plano, String login, Boolean hasResiduo,
                   Boolean isVendedor, Boolean hasTransporte, String email) {
        this.idUsuario = idUsuario;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.contato = contato;
        this.hasCnpj = hasCnpj;
        this.cnpj = cnpj;
        this.nome = nome;
        this.residuo = residuo;
        this.plano = plano;
        this.login = login;
        this.hasResiduo = hasResiduo;
        this.isVendedor = isVendedor;
        this.hasTransporte = hasTransporte;
        this.email = email;
    }

    public Boolean usuarioExists(Usuario usuario) {
        if (usuario.hasCnpj && usuario.hasResiduo) {
            return true;
        }
        return false;
    }
}
