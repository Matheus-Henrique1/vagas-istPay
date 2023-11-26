package istPay.example.vagasistPay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoVaga implements Serializable {

    @EmbeddedId
    private CandidatoVagaPK id;

    @JoinColumn(name = "id_candidato")
    @MapsId("idCandidato")
    @ManyToOne
    private Candidato candidato;

    @JoinColumn(name = "id_vaga")
    @MapsId("idVaga")
    @ManyToOne
    private Vaga vaga;
}
