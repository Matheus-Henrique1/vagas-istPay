package istPay.example.vagasistPay.dto;

import istPay.example.vagasistPay.entity.Vaga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoDTO implements Serializable {

    private String nome;
    private String rg;
    private String cpf;
    private Date dtNascimento;
    private String experienciasProfissionais;
    private Set<Vaga> vagas;

}
