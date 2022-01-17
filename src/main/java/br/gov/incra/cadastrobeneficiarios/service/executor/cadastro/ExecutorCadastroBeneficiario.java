package br.gov.incra.cadastrobeneficiarios.service.executor.cadastro;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;
import br.gov.incra.cadastrobeneficiarios.model.repository.BeneficiarioRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

@Service
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
