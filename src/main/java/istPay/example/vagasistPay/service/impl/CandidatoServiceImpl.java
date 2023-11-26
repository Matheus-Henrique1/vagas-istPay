package istPay.example.vagasistPay.service.impl;

import istPay.example.vagasistPay.dto.CandidatoDTO;
import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.entity.Candidato;
import istPay.example.vagasistPay.repository.CandidatoRepository;
import istPay.example.vagasistPay.service.CandidatoService;
import istPay.example.vagasistPay.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidatoServiceImpl implements CandidatoService {

    private CandidatoRepository candidatoRepository;

    @Autowired
    public CandidatoServiceImpl(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    @Override
    public RetornoPadraoDTO cadastrar(CandidatoDTO dto) {

        Optional<Candidato> teste = candidatoRepository.findByCpfOrRg(dto.getCpf(), dto.getRg());
        if (!teste.isEmpty()) {
            return Utils.retornoPadrao("Já existe um candidato cadastrado no sistema com esse CPF ou RG.");
        }
        Candidato candidato = dtoParaEntidade(new Candidato(), dto);
        return Utils.retornoPadrao("Candidato cadastrado com sucesso!", candidatoRepository.save(candidato).getId());
    }

    private Candidato dtoParaEntidade(Candidato entidade, CandidatoDTO dto) {
        return entidade.builder()
                .id(dto.getId())
                .rg(dto.getRg())
                .cpf(dto.getCpf())
                .nome(dto.getNome())
                .dtNascimento(dto.getDtNascimento())
                .experienciasProfissionais(dto.getExperienciasProfissionais())
                .build();
    }


}
