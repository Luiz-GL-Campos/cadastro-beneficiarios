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
    private Long idEstado;
    @Column(name = "sigla_estado")
    private String siglaEstado;
    @Column(name = "nome_estado")
    private String nomeEstado;
    
    public Long getIdEstado() {
        return this.idEstado;
    }
    
    public String getSiglaEstado() {
        return this.siglaEstado;
    }
    
    public String getNomeEstado() {
        return this.nomeEstado;
    }

    public Estado() {}
    
    public Estado(Long idEstado, String siglaEstado, String nomeEstado) {
        this.idEstado = idEstado;
        this.siglaEstado = siglaEstado;
        this.nomeEstado = nomeEstado;
    }
}
