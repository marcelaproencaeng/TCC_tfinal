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
    @Column
    private String razaoSocial;
    //    @OneToOne(mappedBy = "cliente")
//    private Endereco endereco;
//    @Column
//    private Contato contato;
    @Column
    private Boolean hasCnpj;
    @Column
    private String cnpj;
    @Column
    private String nome;
    @ManyToMany
    @JoinTable(name = "associacao_usuario_residuo")
    private List<Residuo> residuos;
//    @ManyToOne
//    private Plano plano;
    @Column
    private Boolean hasResiduo;
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
                   Boolean hasCnpj, String cnpj, String nome,
                   List<Residuo> residuos,
//                   Plano plano,
                   Boolean hasResiduo, Boolean isVendedor,
                   Boolean hasTransporte, String email) {
        this.idUsuario = idUsuario;
        this.razaoSocial = razaoSocial;
//        this.endereco = endereco;
//        this.contato = contato;
        this.hasCnpj = hasCnpj;
        this.cnpj = cnpj;
        this.nome = nome;
        this.residuos = residuos;
//        this.plano = plano;
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
