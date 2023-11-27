package istPay.example.vagasistPay.controller;

import io.swagger.v3.oas.annotations.Operation;
import istPay.example.vagasistPay.dto.CandidatoDTO;
import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.service.CandidatoService;
import istPay.example.vagasistPay.utils.Mensagens;
import istPay.example.vagasistPay.utils.Utils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    CandidatoService candidatoService;

    @Autowired
    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @PostMapping
    @Operation(summary = "Endpoint responsável por cadastrar candidato.")
    public ResponseEntity<RetornoPadraoDTO> cadastrar(@Valid @RequestBody CandidatoDTO dto) {
        try {
            return new ResponseEntity<>(candidatoService.cadastrar(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Utils.retornoPadrao(Mensagens.ERRO_CADASTRAR_CANDIDATO), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    @Operation(summary = "Endpoint responsável por atualizar candidato.")
    public ResponseEntity<RetornoPadraoDTO> atualizar(@Valid @RequestBody CandidatoDTO dto) {
        try {
            return new ResponseEntity<>(candidatoService.atualizar(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Utils.retornoPadrao(Mensagens.ERRO_ATUALIZAR_CANDIDATO), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint responsável por deletar candidato.")
    public ResponseEntity<RetornoPadraoDTO> deletar(@PathVariable("id") Long idCandidato) {
        try {
            return new ResponseEntity<>(candidatoService.deletar(idCandidato), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Utils.retornoPadrao(Mensagens.ERRO_DELETAR_CANDIDATO), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @Operation(summary = "Endpoint responsável por buscar todos candidatos.")
    public ResponseEntity<List<CandidatoDTO>> buscarTodosCandidatos() throws Exception {
        try {
            return new ResponseEntity<>(candidatoService.buscarTodosCandidatos(), HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception(Mensagens.ERRO_BUSCAR_CANDIDATOS);
        }
    }

    @DeleteMapping
    @Operation(summary = "Endpoint responsável por deletar todos candidatos.")
    public ResponseEntity<RetornoPadraoDTO> deletarTodosCandidatos() {
        try {
            return new ResponseEntity<>(candidatoService.deletarTodosCandidatos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Utils.retornoPadrao(Mensagens.ERRO_DELETAR_TODOS_CANDIDATOS), HttpStatus.BAD_REQUEST);
        }
    }

}
