package istPay.example.vagasistPay.entity;

import istPay.example.vagasistPay.tipoContratacaoEnum.TipoContratacaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vaga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String requisitos;
    private String nivelExperiencia;
    private Date dataPublicacao;
    @Enumerated(EnumType.STRING)
    private TipoContratacaoEnum tipoContratacao;
    private boolean ativa;

}
