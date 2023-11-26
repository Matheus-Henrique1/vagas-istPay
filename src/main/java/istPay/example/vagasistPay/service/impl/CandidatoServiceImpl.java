package istPay.example.vagasistPay.service.impl;

import istPay.example.vagasistPay.dto.CandidatoDTO;
import istPay.example.vagasistPay.dto.RetornoPadraoDTO;
import istPay.example.vagasistPay.dto.VagaDTO;
import istPay.example.vagasistPay.entity.Candidato;
import istPay.example.vagasistPay.entity.Vaga;
import istPay.example.vagasistPay.repository.CandidatoRepository;
import istPay.example.vagasistPay.repository.CandidatoVagaRepository;
import istPay.example.vagasistPay.service.CandidatoService;
import istPay.example.vagasistPay.utils.Mensagens;
import istPay.example.vagasistPay.utils.Utils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CandidatoServiceImpl implements CandidatoService {

    private CandidatoRepository candidatoRepository;
    private CandidatoVagaRepository candidatoVagaRepository;

    @Autowired
    public CandidatoServiceImpl(CandidatoRepository candidatoRepository, CandidatoVagaRepository candidatoVagaRepository) {
        this.candidatoRepository = candidatoRepository;
        this.candidatoVagaRepository = candidatoVagaRepository;
    }

    @Override
    @Transactional
    public RetornoPadraoDTO cadastrar(CandidatoDTO dto) {

        Optional<Candidato> candidatoExiste = candidatoRepository.buscarPorCPFOuRG(dto.getCpf(), dto.getRg());
        if (!candidatoExiste.isEmpty()) {
            return Utils.retornoPadrao(Mensagens.JA_EXISTE_CANDIDATO);
        }
        Candidato candidato = dtoParaEntidade(new Candidato(), dto);
        return Utils.retornoPadrao(Mensagens.SUCESSO_CADASTRAR_CANDIDATO, candidatoRepository.save(candidato).getId());
    }

    @Override
    @Transactional
    public RetornoPadraoDTO atualizar(CandidatoDTO dto) {
        Candidato candidato = candidatoRepository.buscarPorId(dto.getId());
        if (Objects.nonNull(candidato)) {
            return Utils.retornoPadrao(Mensagens.SUCESSO_ATUALIZAR_CANDIDATO, candidatoRepository.save(dtoParaEntidade(candidato, dto)).getId());
        } else {
            return Utils.retornoPadrao(Mensagens.NAO_LOCALIZADA_ATUALIZAR_CANDIDATO);
        }
    }

    @Override
    @Transactional
    public RetornoPadraoDTO deletar(Long idCandidato) {
        if (Objects.nonNull(candidatoRepository.buscarPorId(idCandidato))) {
            candidatoRepository.deleteById(idCandidato);
            return Utils.retornoPadrao(Mensagens.SUCESSO_DELETAR_CANDIDATO);
        } else {
            return Utils.retornoPadrao(Mensagens.NAO_LOCALIZADA_DELETAR_CANDIDATO);
        }
    }

    @Override
    public List<CandidatoDTO> buscarTodosCandidatos() {
        List<Candidato> cadidatos = candidatoRepository.findAll();
        List<CandidatoDTO> candidatoDTOS = new ArrayList<>();
        cadidatos.forEach(
                c -> {
                    candidatoDTOS.add(entidadeParaDTO(new CandidatoDTO(), c, candidatoVagaRepository.buscarVagasPorCandidato(c.getId())));
                }
        );

        return candidatoDTOS;
    }

    @Override
    @Transactional
    public RetornoPadraoDTO deletarTodosCandidatos() {
        List<Candidato> candidatos = candidatoRepository.findAll();
        if (candidatos.isEmpty()) {
            return Utils.retornoPadrao(Mensagens.NAO_EXISTE_CANDIDATOS_PARA_DELETAR);
        } else {
            candidatoRepository.deleteAll(candidatos);
            return Utils.retornoPadrao(Mensagens.SUCESSO_DELETAR_TODOS_CANDIDATOS);
        }
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

    private CandidatoDTO entidadeParaDTO(CandidatoDTO dto, Candidato candidato) {
        return dto.builder()
                .id(candidato.getId())
                .rg(candidato.getRg())
                .cpf(candidato.getCpf())
                .nome(candidato.getNome())
                .dtNascimento(candidato.getDtNascimento())
                .experienciasProfissionais(candidato.getExperienciasProfissionais())
                .build();
    }

    private CandidatoDTO entidadeParaDTO(CandidatoDTO dto, Candidato candidato, List<Vaga> vagas) {
        return dto.builder()
                .id(candidato.getId())
                .rg(candidato.getRg())
                .cpf(candidato.getCpf())
                .nome(candidato.getNome())
                .dtNascimento(candidato.getDtNascimento())
                .experienciasProfissionais(candidato.getExperienciasProfissionais())
                .vagas(entidadeVagaParaDTO(vagas))
                .build();
    }

    private List<VagaDTO> entidadeVagaParaDTO(List<Vaga> vagas) {
        List<VagaDTO> vagaDTOS = new ArrayList<>();
        for (Vaga vaga : vagas) {
            VagaDTO dto = VagaDTO.builder()
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

            vagaDTOS.add(dto);
        }
        return vagaDTOS;
    }
}
