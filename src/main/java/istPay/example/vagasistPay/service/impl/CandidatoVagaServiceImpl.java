package istPay.example.vagasistPay.service.impl;

import istPay.example.vagasistPay.dto.CandidatoVagaDTO;
import istPay.example.vagasistPay.entity.Candidato;
import istPay.example.vagasistPay.entity.CandidatoVaga;
import istPay.example.vagasistPay.entity.CandidatoVagaPK;
import istPay.example.vagasistPay.entity.Vaga;
import istPay.example.vagasistPay.repository.CandidatoRepository;
import istPay.example.vagasistPay.repository.CandidatoVagaRepository;
import istPay.example.vagasistPay.repository.VagaRepository;
import istPay.example.vagasistPay.service.CandidatoVagaService;
import org.springframework.stereotype.Service;

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
    public String inscricaoVaga(CandidatoVagaDTO dto) {
        Candidato candidato = candidatoRepository.getReferenceById(dto.getIdCandidato());
        Vaga vaga = vagaRepository.getReferenceById(dto.getIdVaga());

        CandidatoVaga candidatoVaga = new CandidatoVaga(new CandidatoVagaPK(candidato.getId(), vaga.getId()), candidato, vaga);

        candidatoVagaRepository.save(candidatoVaga);

        return "Deu bom";
    }
}
