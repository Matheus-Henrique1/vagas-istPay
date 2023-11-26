package istPay.example.vagasistPay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CandidatoDTO implements Serializable {

    private Long id;
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;
    @NotEmpty(message = "{campo.rg.obrigatorio}")
    private String rg;
    @NotEmpty(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;
    @NotNull(message = "{campo.dat-nascimento.obrigatorio}")
    private Date dtNascimento;
    private String experienciasProfissionais;
    private List<VagaDTO> vagas = new ArrayList<>();

}
