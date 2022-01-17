package br.gov.incra.cadastrobeneficiarios.service.executor.altera;

import br.gov.incra.cadastrobeneficiarios.model.repository.EmailRepository;
import br.gov.incra.cadastrobeneficiarios.service.executor.AbstractExecutorCadastroEmail;

public class ExecutorAlteraConta extends AbstractExecutorCadastroEmail {
    
    public ExecutorAlteraConta(EmailRepository emailRepository) {
        super(emailRepository);
    }

    @Override
    protected boolean isFuncionalidadeAlteracaoEmail() {
        return true;
    }
}
