package br.gov.incra.cadastrobeneficiarios.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.model.dto.BeneficiarioDTO;
import br.gov.incra.cadastrobeneficiarios.model.dto.ListarBeneficiarioDTO;
import br.gov.incra.cadastrobeneficiarios.service.AlteraBeneficiarioService;
import br.gov.incra.cadastrobeneficiarios.service.CadastroBeneficiarioService;
import br.gov.incra.cadastrobeneficiarios.service.DetalhaBeneficiarioService;
import br.gov.incra.cadastrobeneficiarios.service.ExcluirBeneficiarioService;
import br.gov.incra.cadastrobeneficiarios.service.ListarBeneficiarioService;

@RestController
@RequestMapping(path = "/beneficiario")
public class BeneficiarioController {

    public final CadastroBeneficiarioService cadastroBeneficiarioService;
    public final AlteraBeneficiarioService alteraBeneficiarioService;
    public final ExcluirBeneficiarioService excluirBeneficiarioService;
    public final DetalhaBeneficiarioService detalhaBeneficiarioService;
    public final ListarBeneficiarioService listarBeneficiarioService;
    
    public BeneficiarioController(CadastroBeneficiarioService cadastroBeneficiarioService, 
        AlteraBeneficiarioService alteraBeneficiarioService,
        ExcluirBeneficiarioService excluirBeneficiarioService,
        DetalhaBeneficiarioService detalhaBeneficiarioService,
        ListarBeneficiarioService listarBeneficiarioService
    ) {
        this.cadastroBeneficiarioService = cadastroBeneficiarioService;
        this.alteraBeneficiarioService = alteraBeneficiarioService;
        this.excluirBeneficiarioService = excluirBeneficiarioService;
        this.detalhaBeneficiarioService = detalhaBeneficiarioService;
        this.listarBeneficiarioService = listarBeneficiarioService;
    }

    @PostMapping
    public ResponseEntity<BeneficiarioDTO> cadastrar(@RequestBody CadastroBeneficiarioForm cadastroBeneficiarioForm){
        return ResponseEntity.created(URI.create("")).body(cadastroBeneficiarioService.cadastrar(cadastroBeneficiarioForm));
    }

    @PutMapping
    public ResponseEntity<BeneficiarioDTO> alterarBeneficiario(@RequestBody CadastroBeneficiarioForm cadastroBeneficiarioForm){
        return ResponseEntity.ok(alteraBeneficiarioService.altera(cadastroBeneficiarioForm));
    }

    @DeleteMapping(path = "/{cpf}")
    public ResponseEntity<?> excluir(@PathVariable String cpf){
        return ResponseEntity.ok(excluirBeneficiarioService.excluir(cpf));
    }

    @GetMapping(path = "/{cpf}")
    public ResponseEntity<?> detalhar(@PathVariable String cpf){
        return ResponseEntity.ok(detalhaBeneficiarioService.obterPor(cpf));
    }

    @GetMapping
    public ResponseEntity<List<ListarBeneficiarioDTO>> listar(){
        return ResponseEntity.ok(listarBeneficiarioService.listar());
    }
}
