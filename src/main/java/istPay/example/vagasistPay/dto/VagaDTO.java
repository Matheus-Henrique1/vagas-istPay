package istPay.example.vagasistPay.dto;

import istPay.example.vagasistPay.tipoContratacaoEnum.TipoContratacaoEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTO implements Serializable {

    private Long id;
    @NotEmpty(message = "{campo.nome-empresa.obrigatorio}")
    private String nomeEmpresa;
    private Integer numeroDeVagas;
    @NotEmpty(message = "{campo.titulo.obrigatorio}")
    private String titulo;
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;
    @NotEmpty(message = "{campo.requisitos.obrigatorio}")
    private String requisitos;
    private String nivelExperiencia;
    @NotNull(message = "{campo.dat-publicacao.obrigatorio}")
    private Date dataPublicacao;
    @NotNull(message = "{campo.tip-contratacao.obrigatorio}")
    private TipoContratacaoEnum tipoContratacao;
    private String observacao;
    private boolean ativa;

}
