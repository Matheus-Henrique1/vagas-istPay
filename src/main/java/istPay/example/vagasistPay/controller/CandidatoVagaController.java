package istPay.example.vagasistPay.controller;

import io.swagger.v3.oas.annotations.Operation;
import istPay.example.vagasistPay.dto.CandidatoVagaDTO;
import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.service.CandidatoVagaService;
import istPay.example.vagasistPay.utils.Mensagens;
import istPay.example.vagasistPay.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "Endpoint responsável por fazer a inscricao do candidato na vaga.")
    public ResponseEntity<RetornoPadraoDTO> cadastrar(@RequestBody CandidatoVagaDTO dto) {
        try {
            return new ResponseEntity<>(candidatoVagaService.inscricaoVaga(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Utils.retornoPadrao(Mensagens.ERRO_INSCRICAO_VAGA), HttpStatus.BAD_REQUEST);
        }
    }


}
