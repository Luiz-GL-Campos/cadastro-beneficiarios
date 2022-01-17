package br.gov.incra.cadastrobeneficiarios.service.executor.altera;

import br.gov.incra.cadastrobeneficiarios.model.repository.EnderecoRepository;
import br.gov.incra.cadastrobeneficiarios.service.executor.AbstractExecutorCadastroEndereco;

public class ExecutorAlteraEndereco extends AbstractExecutorCadastroEndereco {
    
    public ExecutorAlteraEndereco(EnderecoRepository enderecoRepository){
        super(enderecoRepository);
    }

    @Override
    protected boolean isFuncionalidadeAlteracaoEndereco() {
        return true;
    }
}
