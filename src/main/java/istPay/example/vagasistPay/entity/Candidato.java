package istPay.example.vagasistPay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private Date dtNascimento;
    private String experienciasProfissionais;
    @OneToMany
    @JoinTable(
            name = "inscricao",
            joinColumns = @JoinColumn(name = "candidato_id"),
            inverseJoinColumns = @JoinColumn(name = "vaga_id"))
    private Set<Vaga> vagas = new HashSet<>();

}
