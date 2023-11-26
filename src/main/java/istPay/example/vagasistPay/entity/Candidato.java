package istPay.example.vagasistPay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Candidato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato")
    private Long id;

    @Column(name = "nom_candidato")
    private String nome;

    @Column(name = "rg_candidato")
    private String rg;

    @Column(name = "cpf_candidato")
    private String cpf;

    @Column(name = "dat_nas_candidato")
    private Date dtNascimento;

    @Column(name = "exp_pro_candidato")
    private String experienciasProfissionais;

}
