package br.gov.incra.cadastrobeneficiarios.model.dto;

import br.gov.incra.cadastrobeneficiarios.model.entity.Estado;

public class EstadoDTO {
    private Long idEstado;
    private String siglaEstado;
    private String nomeEstado;

    public EstadoDTO(Estado estado) {
        this.idEstado = estado.getIdEstado();
        this.siglaEstado = estado.getSiglaEstado();
        this.nomeEstado = estado.getNomeEstado();
    }

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