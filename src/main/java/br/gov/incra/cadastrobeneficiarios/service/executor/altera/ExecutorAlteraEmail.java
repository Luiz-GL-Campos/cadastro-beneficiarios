package br.gov.incra.cadastrobeneficiarios.service.executor.altera;

import br.gov.incra.cadastrobeneficiarios.model.repository.EmailRepository;
import br.gov.incra.cadastrobeneficiarios.service.executor.AbstractExecutorCadastroEmail;

public class ExecutorAlteraEmail extends AbstractExecutorCadastroEmail {
    
    public ExecutorAlteraEmail(EmailRepository emailRepository) {
        super(emailRepository);
    }

    @Override
    protected boolean isFuncionalidadeAlteracaoEmail() {
        return true;
    }
}
