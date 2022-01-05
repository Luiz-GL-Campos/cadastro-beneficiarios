package br.gov.incra.cadastrobeneficiarios.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_conta", schema = "beneficiario")
public class TipoConta {
    @Id
    @Column(name = "id_tipo_conta")
    Long idTipoConta;
    @Column(name = "tipo_conta")
    String tipoConta;

    public Long getIdTipoConta() {
        return this.idTipoConta;
    }

    public String getTipoConta() {
        return this.tipoConta;
    }

}
