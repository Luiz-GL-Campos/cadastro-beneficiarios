package br.gov.incra.cadastrobeneficiarios.service.executor;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;
import br.gov.incra.cadastrobeneficiarios.model.repository.BeneficiarioRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

public class ExecutorCadastroBeneficiario implements AcaoCadastroBeneficiario {

    private final BeneficiarioRepository beneficiarioRepository;

    public ExecutorCadastroBeneficiario(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
    }

    @Override
    public void executa(CadastroBeneficiarioForm form) {
        Beneficiario beneficiario = new Beneficiario(form.getBeneficiario());
        beneficiarioRepository.save(beneficiario);
        
    }
    
}
