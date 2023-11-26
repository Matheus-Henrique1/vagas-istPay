package istPay.example.vagasistPay.service;

import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.dto.VagaDTO;

public interface VagaService {

    RetornoPadraoDTO cadastrar(VagaDTO dto);
}
