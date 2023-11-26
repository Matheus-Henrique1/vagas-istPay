package istPay.example.vagasistPay.service.impl;

import istPay.example.vagasistPay.dto.CandidatoVagaDTO;
import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.entity.Candidato;
import istPay.example.vagasistPay.entity.CandidatoVaga;
import istPay.example.vagasistPay.entity.CandidatoVagaPK;
import istPay.example.vagasistPay.entity.Vaga;
import istPay.example.vagasistPay.repository.CandidatoRepository;
import istPay.example.vagasistPay.repository.CandidatoVagaRepository;
import istPay.example.vagasistPay.repository.VagaRepository;
import istPay.example.vagasistPay.service.CandidatoVagaService;
import istPay.example.vagasistPay.utils.Mensagens;
import istPay.example.vagasistPay.utils.Utils;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CandidatoVagaServiceImpl implements CandidatoVagaService {

    private CandidatoVagaRepository candidatoVagaRepository;
    private CandidatoRepository candidatoRepository;
    private VagaRepository vagaRepository;

    public CandidatoVagaServiceImpl(CandidatoVagaRepository candidatoVagaRepository, CandidatoRepository candidatoRepository,
                                    VagaRepository vagaRepository) {
        this.candidatoVagaRepository = candidatoVagaRepository;
        this.candidatoRepository = candidatoRepository;
        this.vagaRepository = vagaRepository;
    }

    @Override
    @Transactional
    public RetornoPadraoDTO inscricaoVaga(CandidatoVagaDTO dto) {
        Candidato candidato = candidatoRepository.buscarPorId(dto.getIdCandidato());
        Vaga vaga = vagaRepository.buscarPorId(dto.getIdVaga());

        if (Objects.isNull(candidato)) {
            return Utils.retornoPadrao(Mensagens.CANDIDATO_NAO_ENCONTRADO_INSCRICAO_VAGA);
        }
        if (Objects.isNull(vaga)) {
            return Utils.retornoPadrao(Mensagens.VAGA_NAO_ENCONTRADA_INSCRICAO_VAGA);
        }
        if (vaga.isAtiva()) {
            CandidatoVaga candidatoVaga = new CandidatoVaga(new CandidatoVagaPK(candidato.getId(), vaga.getId()), candidato, vaga);
            candidatoVagaRepository.save(candidatoVaga);
            return Utils.retornoPadrao(Mensagens.SUCESSO_INSCRICAO_VAGA);
        } else {
            return Utils.retornoPadrao(Mensagens.VAGA_CONGELADA_INSCRICAO_VAGA);
        }
    }
}
