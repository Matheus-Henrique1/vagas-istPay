package istPay.example.vagasistPay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoVagaDTO implements Serializable {

    private Long idCandidato;
    private Long idVaga;
}
