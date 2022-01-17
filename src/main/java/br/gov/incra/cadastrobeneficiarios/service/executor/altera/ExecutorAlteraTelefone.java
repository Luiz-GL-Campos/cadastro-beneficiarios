package br.gov.incra.cadastrobeneficiarios.service.executor.altera;

import br.gov.incra.cadastrobeneficiarios.model.repository.TelefoneRepository;
import br.gov.incra.cadastrobeneficiarios.service.executor.AbstractExecutorCadastroTelefone;

public class ExecutorAlteraTelefone extends AbstractExecutorCadastroTelefone {

    public ExecutorAlteraTelefone(TelefoneRepository telefoneRepository) {
        super(telefoneRepository);
    }

    @Override
    protected boolean isFuncionalidadeAlteracaoTelefone() {
        return true;
    }
    
}
