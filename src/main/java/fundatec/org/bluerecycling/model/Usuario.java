package fundatec.org.bluerecycling.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
//            (nullable = false)
    private Long idUsuario;
    @Column(name = "razãoSocial", length = 255)
    private String razaoSocial;
    //    @OneToOne(mappedBy = "cliente")
//    private Endereco endereco;
//    @Column
//    private Contato contato;
    @Column(name = "tem_cnpj")
    private Boolean hasCnpj;
    @Column(name = "userName", length = 14)
    private String userName;
    @Column(name = "cnpj", length = 14)
    private String cnpj;
    @Column(name = "nome", length = 255)
    private String nome;
    @Column(name = "resíduo_de_interesse")
    private Boolean hasResiduoDeInteresse;
    @Column(name = "vendedor")
    private Boolean isVendedor;
    @Column(name = "Transporte")
    private Boolean hasTransporte;
    @Column(name = "Email")
    private String email;
//    @ManyToMany
//    @JoinTable(name = "associacao_usuario_residuo")
//    private List<Residuo> residuos;
//    @ManyToOne
//    private Plano plano;


    public Usuario() {

    }

    public Usuario(Long idUsuario,
                   String razaoSocial,
//                   Endereco endereco,
//                   Contato contato,
                   Boolean hasCnpj, String userName, String cnpj,
                   String nome,
//                   List<Residuo> residuos,
//                   Plano plano,
                   Boolean hasResiduoDeInteresse, Boolean isVendedor,
                   Boolean hasTransporte, String email) {
        this.idUsuario = idUsuario;
        this.razaoSocial = razaoSocial;
//        this.endereco = endereco;
//        this.contato = contato;
        this.hasCnpj = hasCnpj;
        this.userName = userName;
        this.cnpj = cnpj;
        this.nome = nome;
//        this.residuos = residuos;
//        this.plano = plano;
        this.hasResiduoDeInteresse = hasResiduoDeInteresse;
        this.isVendedor = isVendedor;
        this.hasTransporte = hasTransporte;
        this.email = email;
    }

    //    public Boolean usuarioExists(Usuario usuario) {
//        if (!usuario.hasCnpj | !usuario.hasResiduoDeInteresse) {
//            throw new RuntimeException("Usuário inválido!");
//        }
//        return true;
//    }
    public Boolean usuarioExists(Usuario usuario) {
        if ( usuario.getCnpj() == null||!usuario.hasCnpj == true || usuario.getHasResiduoDeInteresse() == null
                ||!usuario.hasResiduoDeInteresse == true
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O usuário não atende aos critérios necessários");
        }
        return true;
    }

    public Boolean userNameValue(Usuario usuario) {
        if (usuario.getUserName() == null || !usuario.getUserName().equals(cnpj)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "UserName inválido!");
        }
        return true;

    }

//    public Boolean hasInteresse(Usuario usuario) {
//        if (usuario.getHasResiduoDeInteresse() == null || usuario.hasResiduoDeInteresse == false) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O usuário não tem resíduo de interesse");
//        }
//        return true;
//    }
}
