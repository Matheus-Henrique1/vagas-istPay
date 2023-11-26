package istPay.example.vagasistPay.service;

import istPay.example.vagasistPay.dto.CandidatoDTO;
import istPay.example.vagasistPay.dto.RetornoPadraoDTO;

import java.util.List;

public interface CandidatoService {

    RetornoPadraoDTO cadastrar(CandidatoDTO dto);

    RetornoPadraoDTO atualizar(CandidatoDTO dto);

    RetornoPadraoDTO deletar(Long idCandidato);

    List<CandidatoDTO> buscarTodosCandidatos();

    RetornoPadraoDTO deletarTodosCandidatos();
}
