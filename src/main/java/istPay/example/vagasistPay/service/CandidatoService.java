package istPay.example.vagasistPay.service;

import istPay.example.vagasistPay.dto.CandidatoDTO;
import istPay.example.vagasistPay.dto.RetornoPadraoDTO;

public interface CandidatoService {

    RetornoPadraoDTO cadastrar(CandidatoDTO dto);
}
