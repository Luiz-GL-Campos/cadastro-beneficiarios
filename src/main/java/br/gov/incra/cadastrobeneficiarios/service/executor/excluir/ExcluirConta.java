package br.gov.incra.cadastrobeneficiarios.service.executor.excluir;

import br.gov.incra.cadastrobeneficiarios.model.repository.ContaRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoExcluirBeneficiario;

public class ExcluirConta implements AcaoExcluirBeneficiario {

    private final ContaRepository contaRepository;

    public ExcluirConta(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public void executa(String cpf) {
        contaRepository.deleteByCpf(cpf);
    }
    
}
