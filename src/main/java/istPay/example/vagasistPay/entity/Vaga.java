package istPay.example.vagasistPay.entity;

import istPay.example.vagasistPay.tipoContratacaoEnum.TipoContratacaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Vaga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaga")
    private Long id;

    @Column(name = "nom_emp_vaga")
    private String nomeEmpresa;

    @Column(name = "num_de_vag_vaga")
    private Integer numeroDeVagas;

    @Column(name = "tit_vaga")
    private String titulo;

    @Column(name = "des_vaga")
    private String descricao;

    @Column(name = "req_vaga")
    private String requisitos;

    @Column(name = "niv_exp_vaga")
    private String nivelExperiencia;

    @Column(name = "dat_pub_vaga")
    private Date dataPublicacao;

    @Column(name = "tip_con_vaga")
    @Enumerated(EnumType.STRING)
    private TipoContratacaoEnum tipoContratacao;

    @Column(name = "obs_vaga")
    private String observacao;

    @Column(name = "ati_vaga")
    private boolean ativa;
}
