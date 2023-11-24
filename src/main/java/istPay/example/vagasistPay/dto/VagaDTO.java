package istPay.example.vagasistPay.dto;

import istPay.example.vagasistPay.tipoContratacaoEnum.TipoContratacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTO implements Serializable {

    private String titulo;
    private String descricao;
    private String requisitos;
    private String nivelExperiencia;
    private Date dataPublicacao;
    private TipoContratacaoEnum tipoContratacao;
    private boolean ativa;

}
