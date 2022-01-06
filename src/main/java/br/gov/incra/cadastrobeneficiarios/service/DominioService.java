package br.gov.incra.cadastrobeneficiarios.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.model.dto.BancoDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.EscolaridadeDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.EstadoDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.GeneroDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.SituacaoDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.TipoContaDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.TipoTelefoneDTO;
import br.gov.incra.cadastrobeneficiarios.model.repository.BancoRepository;
import br.gov.incra.cadastrobeneficiarios.model.repository.EscolaridadeRepository;
import br.gov.incra.cadastrobeneficiarios.model.repository.EstadoRepository;
import br.gov.incra.cadastrobeneficiarios.model.repository.GeneroRepository;
import br.gov.incra.cadastrobeneficiarios.model.repository.SituacaoRepository;
import br.gov.incra.cadastrobeneficiarios.model.repository.TipoContaRepository;
import br.gov.incra.cadastrobeneficiarios.model.repository.TipoTelefoneRepository;

@Service
public class DominioService {
    private final BancoRepository bancoRepository;
    private final EscolaridadeRepository escolaridadeRepository;
    private final EstadoRepository estadoRepository;
    private final GeneroRepository generoRepository;
    private final SituacaoRepository situacaoRepository;
    private final TipoContaRepository tipoContaRepository;
    private final TipoTelefoneRepository tipoTelefoneRepository;

    public DominioService(
            BancoRepository bancoRepository, EscolaridadeRepository escolaridadeRepository, EstadoRepository estadoRepository,
            GeneroRepository generoRepository, SituacaoRepository situacaoRepository, TipoContaRepository tipoContaRepository,
            TipoTelefoneRepository tipoTelefoneRepository
        ) {
        this.bancoRepository = bancoRepository;
        this.escolaridadeRepository = escolaridadeRepository;
        this.estadoRepository = estadoRepository;
        this.generoRepository = generoRepository;
        this.situacaoRepository = situacaoRepository;
        this.tipoContaRepository = tipoContaRepository;
        this.tipoTelefoneRepository = tipoTelefoneRepository;
    }

    public List<BancoDTO> listarBancos() {
        return bancoRepository.findAll().stream().map(BancoDTO::new).collect(Collectors.toList());
    }

    public List<EscolaridadeDTO> listarEscolaridades(){
        return escolaridadeRepository.findAll().stream().map(EscolaridadeDTO::new).collect(Collectors.toList());
    }

    public List<EstadoDTO> listarEstados(){
        return estadoRepository.findAll().stream().map(EstadoDTO::new).collect(Collectors.toList());
    }

    public List<GeneroDTO> listarGeneros(){
        return generoRepository.findAll().stream().map(GeneroDTO::new).collect(Collectors.toList());
    }

    public List<SituacaoDTO> listarSituacoes(){
        return situacaoRepository.findAll().stream().map(SituacaoDTO::new).collect(Collectors.toList());
    }

    public List<TipoContaDTO> listarTiposConta(){
        return tipoContaRepository.findAll().stream().map(TipoContaDTO::new).collect(Collectors.toList());
    }

    public List<TipoTelefoneDTO> listarTiposTelefone(){
        return tipoTelefoneRepository.findAll().stream().map(TipoTelefoneDTO::new).collect(Collectors.toList());
    }
}
