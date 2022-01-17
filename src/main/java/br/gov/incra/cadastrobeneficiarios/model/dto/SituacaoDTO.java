package br.gov.incra.cadastrobeneficiarios.model.dto;

import br.gov.incra.cadastrobeneficiarios.model.entity.Situacao;
import br.gov.incra.cadastrobeneficiarios.model.entity.SituacaoBeneficiarioId;

public class SituacaoDTO {
    private Long idSituacao;
    private String descricaoSituacao;

    public SituacaoDTO(Situacao situacao) {
        this.idSituacao = situacao.getIdSituacao();
        this.descricaoSituacao = situacao.getDescricaoSituacao();
    }

    public SituacaoDTO(SituacaoBeneficiarioId situacaoBeneficiarioId) {
        this.idSituacao = situacaoBeneficiarioId.getSituacao().getIdSituacao();
        this.descricaoSituacao = situacaoBeneficiarioId.getSituacao().getDescricaoSituacao();
    }

    public Long getIdSituacao() {
        return this.idSituacao;
    }

    public String getDescricaoSituacao() {
        return this.descricaoSituacao;
    }

}
