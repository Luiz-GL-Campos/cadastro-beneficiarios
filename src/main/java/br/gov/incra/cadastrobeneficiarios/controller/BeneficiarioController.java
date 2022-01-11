package br.gov.incra.cadastrobeneficiarios.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.service.CadastroBeneficiarioService;

@RestController
@RequestMapping(path = "/beneficiario")
public class BeneficiarioController {

    public final CadastroBeneficiarioService cadastroBeneficiarioService;
    
    public BeneficiarioController(CadastroBeneficiarioService cadastroBeneficiarioService) {
        this.cadastroBeneficiarioService = cadastroBeneficiarioService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(CadastroBeneficiarioForm cadastroBeneficiarioForm){
        return ResponseEntity.created(URI.create("")).body(cadastroBeneficiarioService.cadastrar(cadastroBeneficiarioForm));
    }
}
