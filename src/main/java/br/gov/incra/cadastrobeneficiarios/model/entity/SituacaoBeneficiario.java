package br.gov.incra.cadastrobeneficiarios.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "situacao_beneficiario", schema = "beneficiario")
public class SituacaoBeneficiario {
    @EmbeddedId
    private SituacaoBeneficiarioId situacaoBeneficiarioId;
    @Column(name = "data_atualizacao")
    private LocalDate dataAtualizacao;

    public SituacaoBeneficiario () {}

    public SituacaoBeneficiario (SituacaoBeneficiarioId situacaoBeneficiarioId, LocalDate dataAtualizacao) {
        this.situacaoBeneficiarioId = situacaoBeneficiarioId;
        this.dataAtualizacao = dataAtualizacao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public SituacaoBeneficiarioId getSituacaoBeneficiarioId() {
        return this.situacaoBeneficiarioId;
    }
}
