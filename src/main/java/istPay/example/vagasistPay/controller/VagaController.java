package istPay.example.vagasistPay.controller;

import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.dto.VagaDTO;
import istPay.example.vagasistPay.service.VagaService;
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
@RequestMapping("/vaga")
public class VagaController {

    private VagaService vagaService;

    @Autowired
    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @PostMapping
    public ResponseEntity<RetornoPadraoDTO> cadastrar(@Valid @RequestBody VagaDTO dto) {
        try {
            return new ResponseEntity<>(vagaService.cadastrar(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Utils.retornoPadrao("Erro ao tentar cadastrar vaga."), HttpStatus.BAD_REQUEST);
        }
    }


}
