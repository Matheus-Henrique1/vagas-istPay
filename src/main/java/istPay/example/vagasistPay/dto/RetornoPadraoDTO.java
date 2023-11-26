package istPay.example.vagasistPay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetornoPadraoDTO<T> {

    private String mensagem;
    private T dados;

    public RetornoPadraoDTO(String mensagem) {
        this.mensagem = mensagem;
    }
}
