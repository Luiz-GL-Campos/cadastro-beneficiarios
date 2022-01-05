package br.gov.incra.cadastrobeneficiarios.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado", schema = "beneficiario")
public class Estado {
    @Id
    @Column(name = "id_estado")
    Long idEstado;
    @Column(name = "sigla_estado")
    String siglaEstado;
    @Column(name = "nome_estado")
    String nomeEstado;

    public Long getIdEstado() {
        return this.idEstado;
    }

    public String getSiglaEstado() {
        return this.siglaEstado;
    }

    public String getNomeEstado() {
        return this.nomeEstado;
    }

}
