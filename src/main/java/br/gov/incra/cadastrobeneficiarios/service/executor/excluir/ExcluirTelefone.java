package br.gov.incra.cadastrobeneficiarios.service.executor.excluir;

import br.gov.incra.cadastrobeneficiarios.model.repository.TelefoneRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoExcluirBeneficiario;

public class ExcluirTelefone implements AcaoExcluirBeneficiario {

    private final TelefoneRepository telefoneRepository;

    public ExcluirTelefone(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    @Override
    public void executa(String cpf) {
        telefoneRepository.deleteByCpf(cpf);
    }
    
}
