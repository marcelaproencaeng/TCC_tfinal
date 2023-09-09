package fundatec.org.bluerecycling.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idUsuario;
    @Column(name = "razãoSocial", length = 255)
    private String razaoSocial;
    //    @OneToOne(mappedBy = "cliente")
//    private Endereco endereco;
//    @Column
//    private Contato contato;
    @Column(name = "hasCnpj")
    private Boolean hasCnpj;
    @Column(name = "UserName", length = 14)
    private String UserName;
    @Column(name = "cnpj", length = 14)
    private String cnpj;
    @Column(name = "nome", length = 255)
    private String nome;
    @ManyToMany
    @JoinTable(name = "associacao_usuario_residuo")
    private List<Residuo> residuos;
    //    @ManyToOne
//    private Plano plano;
    @Column
    private Boolean hasResiduoDeInteresse;
    @Column
    private Boolean isVendedor;
    @Column
    private Boolean hasTransporte;
    @Column
    private String email;


    public Usuario() {

    }

    public Usuario(Long idUsuario,
                   String razaoSocial,
//                   Endereco endereco,
//                   Contato contato,
                   Boolean hasCnpj, String UserName, String cnpj,
                   String nome, List<Residuo> residuos,
//                   Plano plano,
                   Boolean hasResiduoDeInteresse, Boolean isVendedor,
                   Boolean hasTransporte, String email) {
        this.idUsuario = idUsuario;
        this.razaoSocial = razaoSocial;
//        this.endereco = endereco;
//        this.contato = contato;
        this.hasCnpj = hasCnpj;
        this.UserName = UserName;
        this.cnpj = cnpj;
        this.nome = nome;
        this.residuos = residuos;
//        this.plano = plano;
        this.hasResiduoDeInteresse = hasResiduoDeInteresse;
        this.isVendedor = isVendedor;
        this.hasTransporte = hasTransporte;
        this.email = email;
    }

    public Boolean usuarioExists(Usuario usuario) {
        if (!usuario.hasCnpj && !usuario.hasResiduoDeInteresse) {
            throw new RuntimeException("Usuário inválido!");
        }
        return true;
    }
}
