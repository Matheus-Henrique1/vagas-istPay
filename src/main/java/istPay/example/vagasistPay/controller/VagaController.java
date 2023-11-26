package istPay.example.vagasistPay.controller;

import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.dto.VagaDTO;
import istPay.example.vagasistPay.service.VagaService;
import istPay.example.vagasistPay.utils.Mensagens;
import istPay.example.vagasistPay.utils.Utils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return new ResponseEntity<>(Utils.retornoPadrao(Mensagens.ERRO_CADASTRAR_VAGA), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<RetornoPadraoDTO> atualizar(@Valid @RequestBody VagaDTO dto) {
        try {
            return new ResponseEntity<>(vagaService.atualizar(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Utils.retornoPadrao(Mensagens.ERRO_ATUALIZAR_VAGA), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RetornoPadraoDTO> deletar(@PathVariable("id") Long idVaga) {
        try {
            return new ResponseEntity<>(vagaService.deletar(idVaga), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Utils.retornoPadrao(Mensagens.ERRO_DELETAR_VAGA), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<VagaDTO>> buscarVagas() throws Exception {
        try {
            return new ResponseEntity<>(vagaService.buscarVagas(), HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception(Mensagens.ERRO_BUSCAR_VAGAS);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RetornoPadraoDTO> congelarVaga(@PathVariable("id") Long idVaga) {
        try {
            return new ResponseEntity<>(vagaService.congelarVaga(idVaga), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Utils.retornoPadrao(Mensagens.ERRO_CONGELAR_VAGA), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/reativar/{id}")
    public ResponseEntity<RetornoPadraoDTO> reativar(@PathVariable("id") Long idVaga) {
        try {
            return new ResponseEntity<>(vagaService.reativarVaga(idVaga), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Utils.retornoPadrao(Mensagens.ERRO_REATIVAR_VAGA), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<RetornoPadraoDTO> deletarTodasVagas() {
        try {
            return new ResponseEntity<>(vagaService.deletarTodasVagas(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Utils.retornoPadrao(Mensagens.ERRO_DELETAR_TODAS_VAGAS), HttpStatus.BAD_REQUEST);
        }
    }

}
