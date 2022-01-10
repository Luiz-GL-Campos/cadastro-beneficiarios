package br.gov.incra.cadastrobeneficiarios.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banco", schema = "beneficiario")
public class Banco {
    @Id
    @Column(name = "cod_banco")
    Long codBanco;
    @Column(name = "nome_banco")
    String nomeBanco;

    public Long getCodBanco() {
        return this.codBanco;
    }

    public String getNomeBanco() {
        return this.nomeBanco;
    }

    public Banco() {}

    public Banco(
        Long codBanco,
        String nomeBanco
    ){
        this.codBanco = codBanco;
        this.nomeBanco = nomeBanco;
    }
}
