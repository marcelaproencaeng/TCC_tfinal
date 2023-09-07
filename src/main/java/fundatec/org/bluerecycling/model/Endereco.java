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
    @Column
    private String Rua;
    @Column
    private Integer cep;
    @Column
    private Integer numero;
    @Column
    private String bairro;
    @Column
//    Poderia ser um Enum
    private String cidade;
    @Column
    private String estado;
    @Column
    private String pais;

    public Endereco(){

    }

    public Endereco(Long idEndereco, Usuario usuario,
                    String rua, Integer cep, Integer numero,
                    String bairro, String cidade, String estado, String pais) {
        this.idEndereco = idEndereco;
        this.usuario = usuario;
        Rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
}
