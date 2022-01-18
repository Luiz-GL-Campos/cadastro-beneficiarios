package br.gov.incra.cadastrobeneficiarios.service.executor.excluir;

import br.gov.incra.cadastrobeneficiarios.model.repository.EmailRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoExcluirBeneficiario;

public class ExcluirEmail implements AcaoExcluirBeneficiario {

    private final EmailRepository emailRepository;

    public ExcluirEmail(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public void executa(String cpf) {
        emailRepository.deleteByCpf(cpf);
    }
    
}
