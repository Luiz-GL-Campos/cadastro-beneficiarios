package br.gov.incra.cadastrobeneficiarios.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "municipio", schema = "beneficiario")
public class Municipio {
    @Id
    @Column(name = "id_municipio")
    private Long idMunicipio;
    @Column(name = "nome_municipio")
    private String nomeMunicipio;
    @Column(name = "id_estado")
    private Long idEstado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", insertable = false, updatable = false)
    private Estado estado;

    public Municipio() {}

    public Municipio(Long idMunicipio, String nomeMunicipio, Long idEstado) {
        this.idMunicipio = idMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.idEstado = idEstado;
    }
    
    public Long getIdMunicipio() {
        return this.idMunicipio;
    }
}
