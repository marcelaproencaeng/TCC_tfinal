package fundatec.org.bluerecycling.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_endereco")
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idEndereco;
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Usuario usuario;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "localidade")
//    Poderia ser um Enum
    private String localidade;
    @Column(name = "uf")
    private String uf;
    @Column(name = "ibge")
    private String ibge;
    @Column(name = "gia")
    private String gia;
    @Column(name = "ddd")
    private String ddd;
    @Column(name = "siafi")
    private String siafi;

    public Endereco() {

    }

    public Endereco(Long idEndereco, Usuario usuario,
                    String cep, String logradouro, String complemento,
                    String bairro, String localidade, String uf, String ibge, String ddd, String siafi) {
        this.idEndereco = idEndereco;
        this.usuario = usuario;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.ddd = ddd;
        this.siafi = siafi;
    }
}
