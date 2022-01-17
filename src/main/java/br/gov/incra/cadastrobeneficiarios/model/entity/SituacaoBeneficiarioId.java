package br.gov.incra.cadastrobeneficiarios.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SituacaoBeneficiarioId implements Serializable {
    
    @Column(name = "cpf_beneficiario")
    private String cpf;

    @Column(name = "id_situacao")
    private Long idSituacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SITUACAO", insertable = false, updatable = false)
    private Situacao situacao;

    public SituacaoBeneficiarioId (){}

    public SituacaoBeneficiarioId(String cpf, Long idSituacao){
        this.cpf = cpf;
        this.idSituacao = idSituacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SituacaoBeneficiarioId)) {
            return false;
        }
        SituacaoBeneficiarioId situacaoBeneficiarioId = (SituacaoBeneficiarioId) o;
        return Objects.equals(cpf, situacaoBeneficiarioId.cpf) && Objects.equals(idSituacao, situacaoBeneficiarioId.idSituacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, idSituacao);
    }

    public Situacao getSituacao() {
        return this.situacao;
    }
}
