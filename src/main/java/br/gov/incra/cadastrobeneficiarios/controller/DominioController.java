package br.gov.incra.cadastrobeneficiarios.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.incra.cadastrobeneficiarios.model.dto.BancoDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.EscolaridadeDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.EstadoDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.GeneroDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.SituacaoDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.TipoContaDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.TipoTelefoneDTO;
import br.gov.incra.cadastrobeneficiarios.service.DominioService;

@RestController
@RequestMapping(path = "/dominio")
public class DominioController {

    private final DominioService dominioService;

    public DominioController(DominioService dominioService) {
        this.dominioService = dominioService;
    }

    @GetMapping(path = "/listar-banco")
    public ResponseEntity<List<BancoDTO>> listarBancos(){
        return ResponseEntity.ok(dominioService.listarBancos());
    }

    @GetMapping(path = "/listar-escolaridade")
    public ResponseEntity<List<EscolaridadeDTO>> listarEscolaridades(){
        return ResponseEntity.ok(dominioService.listarEscolaridades());
    }

    @GetMapping(path = "/listar-estado")
    public ResponseEntity<List<EstadoDTO>> listarEstados(){
        return ResponseEntity.ok(dominioService.listarEstados());
    }

    @GetMapping(path = "/listar-genero")
    public ResponseEntity<List<GeneroDTO>> listarGeneros(){
        return ResponseEntity.ok(dominioService.listarGeneros());
    }
    
    @GetMapping(path = "/listar-situacao")
    public ResponseEntity<List<SituacaoDTO>> listarSituacoes(){
        return ResponseEntity.ok(dominioService.listarSituacoes());
    }

    @GetMapping(path = "/listar-tipo-conta")
    public ResponseEntity<List<TipoContaDTO>> listarTiposConta(){
        return ResponseEntity.ok(dominioService.listarTiposConta());
    }

    @GetMapping(path = "/listar-tipo-telefone")
    public ResponseEntity<List<TipoTelefoneDTO>> listarTiposTelefone(){
        return ResponseEntity.ok(dominioService.listarTiposTelefone());
    }
}
