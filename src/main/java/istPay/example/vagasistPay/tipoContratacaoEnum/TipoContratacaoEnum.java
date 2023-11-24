package istPay.example.vagasistPay.tipoContratacaoEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TipoContratacaoEnum {

    CLT(1, "CLT"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica"),
    FREELANCER(3, "Freelancer");

    private Integer cod;
    private String descricao;

}
