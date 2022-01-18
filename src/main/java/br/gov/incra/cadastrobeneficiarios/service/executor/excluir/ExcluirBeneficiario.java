package br.gov.incra.cadastrobeneficiarios.service.executor.excluir;

import br.gov.incra.cadastrobeneficiarios.model.repository.BeneficiarioRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoExcluirBeneficiario;

public class ExcluirBeneficiario implements AcaoExcluirBeneficiario {
    
    private final BeneficiarioRepository beneficiarioRepository;

    public ExcluirBeneficiario(BeneficiarioRepository beneficiarioRepository){
        this.beneficiarioRepository = beneficiarioRepository;
    }

    @Override
    public void executa(String cpf){
        beneficiarioRepository.deleteById(cpf);
    }

}
