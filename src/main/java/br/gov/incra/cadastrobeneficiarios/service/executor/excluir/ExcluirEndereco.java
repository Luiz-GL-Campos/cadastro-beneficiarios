package br.gov.incra.cadastrobeneficiarios.service.executor.excluir;

import br.gov.incra.cadastrobeneficiarios.model.repository.EnderecoRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoExcluirBeneficiario;

public class ExcluirEndereco implements AcaoExcluirBeneficiario {

    private final EnderecoRepository enderecoRepository;

    public ExcluirEndereco(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public void executa(String cpf) {
        enderecoRepository.deleteByCpf(cpf);
    }
    
}
