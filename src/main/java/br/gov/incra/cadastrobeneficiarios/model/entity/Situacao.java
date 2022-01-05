package br.gov.incra.cadastrobeneficiarios.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "situacao", schema = "beneficiario")
public class Situacao {
    @Id
    @Column(name = "id_situacao")
    Long idSituacao;
    @Column(name = "descricao_situacao")
    String descricaoSituacao;

    public Long getIdSituacao() {
        return this.idSituacao;
    }

    public String getDescricaoSituacao() {
        return this.descricaoSituacao;
    }

}
