package istPay.example.vagasistPay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CandidatoVagaPK implements Serializable {

    @Column(name = "id_candidato")
    private Long idCandidato;

    @Column(name = "id_vaga")
    private Long idVaga;

}
