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
    private Long idTipoConta;
    @Column(name = "tipo_conta")
    private String tipoConta;

    public Long getIdTipoConta() {
        return this.idTipoConta;
    }

    public String getTipoConta() {
        return this.tipoConta;
    }

    public TipoConta (){}

    public TipoConta (Long idTipoConta,String tipoConta) {
        this.idTipoConta = idTipoConta;
        this.tipoConta = tipoConta;
    }
}
