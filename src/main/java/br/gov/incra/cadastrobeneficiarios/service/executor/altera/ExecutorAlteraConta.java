package br.gov.incra.cadastrobeneficiarios.service.executor.altera;

import br.gov.incra.cadastrobeneficiarios.model.repository.ContaRepository;
import br.gov.incra.cadastrobeneficiarios.service.executor.AbstractExecutorCadastroConta;

public class ExecutorAlteraConta extends AbstractExecutorCadastroConta {
    
    public ExecutorAlteraConta(ContaRepository contaRepository) {
        super(contaRepository);
    }

    @Override
    protected boolean isFuncionalidadeAlteracaoConta() {
        return true;
    }
}
