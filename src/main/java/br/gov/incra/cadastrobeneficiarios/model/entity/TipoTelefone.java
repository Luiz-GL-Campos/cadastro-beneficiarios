package br.gov.incra.cadastrobeneficiarios.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_telefone", schema = "beneficiario")
public class TipoTelefone {
    @Id
    @Column(name = "id_tipo_telefone")
    private Long idTipoTelefone;
    @Column(name = "descricao_tipo_telefone")
    private String descricaoTipoTelefone;

    public Long getIdTipoTelefone() {
        return this.idTipoTelefone;
    }

    public String getDescricaoTipoTelefone() {
        return this.descricaoTipoTelefone;
    }

}
