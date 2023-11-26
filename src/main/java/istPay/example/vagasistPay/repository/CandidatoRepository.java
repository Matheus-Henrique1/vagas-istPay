package istPay.example.vagasistPay.repository;

import istPay.example.vagasistPay.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    @Query("SELECT c FROM Candidato c WHERE c.cpf = :cpf OR c.rg = :rg")
    Optional<Candidato> findByCpfOrRg(@Param("cpf") String cpf, @Param("rg") String rg);

}
