package br.gov.incra.cadastrobeneficiarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.model.dto.BeneficiarioDTO;
import br.gov.incra.cadastrobeneficiarios.service.executor.altera.ExecutorAlteraBeneficiario;

@Service
public class AlteraBeneficiarioService {
    private final DetalhaBeneficiarioService detalhaBeneficiarioService;
    private final ExecutorAlteraBeneficiario beneficiario;
    private List<AcaoCadastroBeneficiario> acoes = new ArrayList<>();

    public AlteraBeneficiarioService(DetalhaBeneficiarioService detalhaBeneficiarioService, ExecutorAlteraBeneficiario beneficiario) {
        this.beneficiario = beneficiario;
        this.detalhaBeneficiarioService = detalhaBeneficiarioService;
        adicionaAcoes();
    }

    public BeneficiarioDTO altera(CadastroBeneficiarioForm cadastroBeneficiarioForm){
        return detalhaBeneficiarioService.obterPor(cadastroBeneficiarioForm.getBeneficiario().getCpf());
    }

    private void adicionaAcoes() {
        acoes.clear();
        acoes.add(beneficiario);
    }
}
