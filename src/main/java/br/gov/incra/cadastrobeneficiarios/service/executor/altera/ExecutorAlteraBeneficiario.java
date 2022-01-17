package br.gov.incra.cadastrobeneficiarios.service.executor.altera;

import br.gov.incra.cadastrobeneficiarios.model.repository.BeneficiarioRepository;
import br.gov.incra.cadastrobeneficiarios.service.executor.AbstractExecutorCadastroBeneficiario;

public class ExecutorAlteraBeneficiario extends AbstractExecutorCadastroBeneficiario {
    public ExecutorAlteraBeneficiario(BeneficiarioRepository beneficiarioRepository){
        super(beneficiarioRepository);
    }    
}
