package br.gov.incra.cadastrobeneficiarios.service.executor.cadastro;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.SituacaoBeneficiario;
import br.gov.incra.cadastrobeneficiarios.model.entity.SituacaoBeneficiarioId;
import br.gov.incra.cadastrobeneficiarios.model.repository.SituacaoBeneficiarioRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

@Service
public class ExecutorCadastroSituacao implements AcaoCadastroBeneficiario {
    
    private final SituacaoBeneficiarioRepository situacaoBeneficiarioRepository;

    public ExecutorCadastroSituacao(SituacaoBeneficiarioRepository situacaoBeneficiarioRepository) {
        this.situacaoBeneficiarioRepository = situacaoBeneficiarioRepository;
    }

    @Override
    public void executa(CadastroBeneficiarioForm form) {
        SituacaoBeneficiario situacao = new SituacaoBeneficiario(new SituacaoBeneficiarioId(form.getBeneficiario().getCpf(), 3L));
        situacaoBeneficiarioRepository.save(situacao);
    }
}
