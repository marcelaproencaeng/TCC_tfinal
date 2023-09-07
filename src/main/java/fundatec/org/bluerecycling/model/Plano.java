package fundatec.org.bluerecycling.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tb_plano")
@Data
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idPlano;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assinante_id", referencedColumnName = "idUsuario")
    private Usuario assinante;
    @Column(name = "Credito")
    private Integer credito;
    @Column(length = 5, name = "Valor")
    private Double valor;
    @Column
    private Boolean renovarPlano;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataCriacao;

}
