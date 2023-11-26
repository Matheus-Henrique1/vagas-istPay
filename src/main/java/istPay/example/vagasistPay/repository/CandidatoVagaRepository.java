package istPay.example.vagasistPay.repository;

import istPay.example.vagasistPay.entity.CandidatoVaga;
import istPay.example.vagasistPay.entity.CandidatoVagaPK;
import istPay.example.vagasistPay.entity.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidatoVagaRepository extends JpaRepository<CandidatoVaga, CandidatoVagaPK> {

    @Query("SELECT v FROM CandidatoVaga cv JOIN cv.vaga v WHERE cv.candidato.id = :idCandidato")
    List<Vaga> buscarVagasPorCandidato(Long idCandidato);

    @Query("SELECT cv FROM CandidatoVaga cv WHERE cv.candidato.id = :idCandidato")
    List<CandidatoVaga> buscarPorIdCandidato(Long idCandidato);

    @Query("SELECT cv FROM CandidatoVaga cv WHERE cv.vaga.id = :idVaga")
    List<CandidatoVaga> buscarPorIdVaga(Long idVaga);

}
