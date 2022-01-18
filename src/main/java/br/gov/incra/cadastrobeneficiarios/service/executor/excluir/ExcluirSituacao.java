package br.gov.incra.cadastrobeneficiarios.service.executor.excluir;

import br.gov.incra.cadastrobeneficiarios.model.repository.SituacaoBeneficiarioRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoExcluirBeneficiario;

public class ExcluirSituacao implements AcaoExcluirBeneficiario {

    private final SituacaoBeneficiarioRepository situacaoBeneficiarioRepository;

    public ExcluirSituacao(SituacaoBeneficiarioRepository situacaoBeneficiarioRepository) {
        this.situacaoBeneficiarioRepository = situacaoBeneficiarioRepository;
    }

    @Override
    public void executa(String cpf) {
        situacaoBeneficiarioRepository.deletarPorCpf(cpf);
    }
}
