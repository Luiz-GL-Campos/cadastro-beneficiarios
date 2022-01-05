package br.gov.incra.cadastrobeneficiarios.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genero", schema = "beneficiario")
public class Genero {
    @Id
    @Column(name = "id_genero")
    Long idGenero;
    @Column(name = "tipo_genero")
    String tipoGenero;

    public Long getIdGenero() {
        return this.idGenero;
    }

    public String getTipoGenero() {
        return this.tipoGenero;
    }

}
