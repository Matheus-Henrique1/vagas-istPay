package istPay.example.vagasistPay.service.impl;

import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.dto.VagaDTO;
import istPay.example.vagasistPay.entity.Vaga;
import istPay.example.vagasistPay.repository.VagaRepository;
import istPay.example.vagasistPay.service.VagaService;
import istPay.example.vagasistPay.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaServiceImpl implements VagaService {

    private VagaRepository vagaRepository;

    @Autowired
    public VagaServiceImpl(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    @Override
    public RetornoPadraoDTO cadastrar(VagaDTO dto) {
        Vaga vaga = dtoParaEntidade(new Vaga(), dto);
        return Utils.retornoPadrao("Vaga cadastrada com sucesso!", vagaRepository.save(vaga).getId());
    }


    private Vaga dtoParaEntidade(Vaga vaga, VagaDTO dto) {
        return vaga.builder()
                .nomeEmpresa(dto.getNomeEmpresa())
                .numeroDeVagas(dto.getNumeroDeVagas())
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .requisitos(dto.getRequisitos())
                .nivelExperiencia(dto.getNivelExperiencia())
                .dataPublicacao(dto.getDataPublicacao())
                .tipoContratacao(dto.getTipoContratacao())
                .observacao(dto.getObservacao())
                .ativa(dto.isAtiva())
                .build();
    }
}