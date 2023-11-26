package istPay.example.vagasistPay.repository;

import istPay.example.vagasistPay.entity.Vaga;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

    @Query("SELECT v FROM Vaga v WHERE v.id = :id")
    Vaga findByIdNoOptional(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Vaga v SET v.ativa = :congelar WHERE v.id = :id ")
    void congelarOuReativarVagaPorId(Long id, boolean congelar);

}


