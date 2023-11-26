package istPay.example.vagasistPay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetornoPadraoDTO<T> {

    private String mensagem;
    private T dados;

    public RetornoPadraoDTO(String mensagem) {
        this.mensagem = mensagem;
    }
}
