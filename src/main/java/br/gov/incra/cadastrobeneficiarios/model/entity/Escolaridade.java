package br.gov.incra.cadastrobeneficiarios.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "escolaridade", schema = "beneficiario")
public class Escolaridade {
    @Id
    @Column(name = "id_escolaridade")
    Long idEscolaridade;
    @Column(name = "nivel_escolaridade")
    String nivelEscolaridade;

    public Long getIdEscolaridade() {
        return this.idEscolaridade;
    }

    public String getNivelEscolaridade() {
        return this.nivelEscolaridade;
    }

}
