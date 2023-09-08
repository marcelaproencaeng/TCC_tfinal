//package fundatec.org.bluerecycling.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//@Table(name = "tb_plano")
//@Data
//public class Plano {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column
//    private Long idPlano;
//    //    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "assinante_id", referencedColumnName = "idUsuario")
//    @JoinColumn(name = "id_plano")
//    private List<Usuario> assinantes;
//    @Column(name = "Credito")
//    private Integer credito;
//    @Column(length = 5, name = "Valor")
//    private Double valor;
//    @Column
//    private Boolean renovarPlano;
//    @Column
//    @Temporal(TemporalType.DATE)
//    private LocalDate dataCriacao;
//
//    public Plano() {
//
//    }
//
//    public Plano(Long idPlano,
//                 List<Usuario> assinantes, Integer credito,
//                 Double valor, Boolean renovarPlano, LocalDate dataCriacao) {
//        this.idPlano = idPlano;
//        this.assinantes = assinantes;
//        this.credito = credito;
//        this.valor = valor;
//        this.renovarPlano = renovarPlano;
//        this.dataCriacao = dataCriacao;
//    }
//}
