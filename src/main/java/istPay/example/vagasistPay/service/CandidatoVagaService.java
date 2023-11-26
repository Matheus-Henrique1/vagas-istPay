package istPay.example.vagasistPay.service;

import istPay.example.vagasistPay.dto.CandidatoVagaDTO;
import istPay.example.vagasistPay.dto.RetornoPadraoDTO;

public interface CandidatoVagaService {

    RetornoPadraoDTO inscricaoVaga(CandidatoVagaDTO dto);
}
