package br.gov.incra.cadastrobeneficiarios.model.dto;

import java.time.LocalDate;

import br.gov.incra.cadastrobeneficiarios.model.entity.SituacaoBeneficiario;

public class SituacaoBeneficiarioDTO {
    private LocalDate dataAtualizacao;
    private SituacaoDTO situacaoDTO;

    public SituacaoBeneficiarioDTO(SituacaoBeneficiario situacao) {
        this.dataAtualizacao = situacao.getDataAtualizacao();
        this.situacaoDTO = new SituacaoDTO(situacao.getSituacaoBeneficiarioId());
    }
}
