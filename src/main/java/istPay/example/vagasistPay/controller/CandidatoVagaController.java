package istPay.example.vagasistPay.controller;

import istPay.example.vagasistPay.dto.CandidatoVagaDTO;
import istPay.example.vagasistPay.service.CandidatoVagaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscricao")
public class CandidatoVagaController {

    private CandidatoVagaService candidatoVagaService;

    public CandidatoVagaController(CandidatoVagaService candidatoVagaService) {
        this.candidatoVagaService = candidatoVagaService;
    }

    @PostMapping
    public String cadastrar(@RequestBody CandidatoVagaDTO dto) {
        return candidatoVagaService.inscricaoVaga(dto);
    }


}
