package istPay.example.vagasistPay.repository;

import istPay.example.vagasistPay.entite.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    
}
