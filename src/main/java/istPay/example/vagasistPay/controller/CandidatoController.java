package istPay.example.vagasistPay.controller;

import istPay.example.vagasistPay.dto.CandidatoDTO;
import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.service.CandidatoService;
import istPay.example.vagasistPay.utils.Utils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    CandidatoService candidatoService;

    @Autowired
    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @PostMapping
    public ResponseEntity<RetornoPadraoDTO> cadastrar(@Valid @RequestBody CandidatoDTO dto) {
        try {
            return new ResponseEntity<>(candidatoService.cadastrar(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Utils.retornoPadrao("Erro ao tentar cadastrar candidato."), HttpStatus.BAD_REQUEST);
        }
    }

}
