package istPay.example.vagasistPay.service;

import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.dto.VagaDTO;

import java.util.List;

public interface VagaService {

    RetornoPadraoDTO cadastrar(VagaDTO dto);

    RetornoPadraoDTO atualizar(VagaDTO dto);

    RetornoPadraoDTO deletar(Long idVaga);

    List<VagaDTO> buscarVagas();

    RetornoPadraoDTO congelarVaga(Long idVaga);

    RetornoPadraoDTO reativarVaga(Long idVaga);
}
