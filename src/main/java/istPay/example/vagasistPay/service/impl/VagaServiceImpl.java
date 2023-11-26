package istPay.example.vagasistPay.service.impl;

import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.dto.VagaDTO;
import istPay.example.vagasistPay.entity.Vaga;
import istPay.example.vagasistPay.repository.VagaRepository;
import istPay.example.vagasistPay.service.VagaService;
import istPay.example.vagasistPay.utils.Mensagens;
import istPay.example.vagasistPay.utils.Utils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VagaServiceImpl implements VagaService {

    private VagaRepository vagaRepository;

    @Autowired
    public VagaServiceImpl(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    @Override
    @Transactional
    public RetornoPadraoDTO cadastrar(VagaDTO dto) {
        dto.setAtiva(Boolean.TRUE);
        Vaga vaga = dtoParaEntidade(new Vaga(), dto);
        return Utils.retornoPadrao(Mensagens.SUCESSO_CADASTRAR_VAGA, vagaRepository.save(vaga).getId());
    }

    @Override
    @Transactional
    public RetornoPadraoDTO atualizar(VagaDTO dto) {
        dto.setAtiva(Boolean.TRUE);
        Vaga vaga = vagaRepository.findByIdNoOptional(dto.getId());
        if (Objects.isNull(vaga)) {
            return Utils.retornoPadrao(Mensagens.NAO_LOCALIZADA_ATUALIZAR_VAGA);
        }
        return Utils.retornoPadrao(Mensagens.SUCESSO_ATUALIZAR_VAGA, vagaRepository.save(dtoParaEntidade(vaga, dto)).getId());
    }

    @Override
    @Transactional
    public RetornoPadraoDTO deletar(Long idVaga) {

        if (Objects.nonNull(vagaRepository.findByIdNoOptional(idVaga))) {
            vagaRepository.deleteById(idVaga);
            return Utils.retornoPadrao(Mensagens.SUCESSO_DELETAR_VAGA);
        } else {
            return Utils.retornoPadrao(Mensagens.NAO_LOCALIZADA_DELETAR_VAGA);
        }
    }

    @Override
    public List<VagaDTO> buscarVagas() {
        List<Vaga> vagas = vagaRepository.findAll();
        return vagas.stream()
                .map(vaga -> {
                    return entidadeParaDTO(new VagaDTO(), vaga);
                })
                .toList();
    }

    @Override
    @Transactional
    public RetornoPadraoDTO congelarVaga(Long idVaga) {
        Vaga vaga = vagaRepository.findByIdNoOptional(idVaga);
        if (Objects.isNull(vaga)) {
            return Utils.retornoPadrao(Mensagens.NAO_LOCALIZADA_CONGELAR_VAGA);
        } else {
            vagaRepository.congelarOuReativarVagaPorId(idVaga, Boolean.FALSE);
            return Utils.retornoPadrao(Mensagens.SUCESSO_CONGELAR_VAGA);
        }
    }

    @Override
    @Transactional
    public RetornoPadraoDTO reativarVaga(Long idVaga) {
        Vaga vaga = vagaRepository.findByIdNoOptional(idVaga);
        if (Objects.isNull(vaga)) {
            return Utils.retornoPadrao(Mensagens.NAO_LOCALIZADA_REATIVAR_VAGA);
        } else {
            if (vaga.isAtiva()) {
                return Utils.retornoPadrao(Mensagens.JA_ATIVA_VAGA);
            }
            vagaRepository.congelarOuReativarVagaPorId(idVaga, Boolean.TRUE);
            return Utils.retornoPadrao(Mensagens.SUCESSO_REATIVAR_VAGA);
        }
    }

    private Vaga dtoParaEntidade(Vaga vaga, VagaDTO dto) {
        return vaga.builder()
                .id(dto.getId())
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

    private VagaDTO entidadeParaDTO(VagaDTO dto, Vaga vaga) {
        return dto.builder()
                .id(vaga.getId())
                .nomeEmpresa(vaga.getNomeEmpresa())
                .numeroDeVagas(vaga.getNumeroDeVagas())
                .titulo(vaga.getTitulo())
                .descricao(vaga.getDescricao())
                .requisitos(vaga.getRequisitos())
                .nivelExperiencia(vaga.getNivelExperiencia())
                .dataPublicacao(vaga.getDataPublicacao())
                .tipoContratacao(vaga.getTipoContratacao())
                .observacao(vaga.getObservacao())
                .ativa(vaga.isAtiva())
                .build();
    }
}