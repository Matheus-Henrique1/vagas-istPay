package istPay.example.vagasistPay;

import istPay.example.vagasistPay.dto.CandidatoDTO;
import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.service.CandidatoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class CandidatoServiceTest {

    @Autowired
    private CandidatoService candidatoService;

    @Test
    public void cadastroCandidatoSucessoTest(){
        CandidatoDTO dto = new CandidatoDTO();
            dto.builder()
                .id(null)
                .nome("Igor Gomes")
                .cpf("126.311.240-49")
                .rg("39.181.142-3")
                .experienciasProfissionais("TESTE")
                .build();
        RetornoPadraoDTO retorno = candidatoService.cadastrar(dto);
        Assert.assertEquals(retorno.getMensagem(), "Candidato cadastrado com sucesso!");
    }


}
