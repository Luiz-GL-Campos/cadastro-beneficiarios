package br.gov.incra.cadastrobeneficiarios.model.dto;

import br.gov.incra.cadastrobeneficiarios.model.entity.Genero;

public class GeneroDTO {
    private Long idGenero;
    private String tipoGenero;

    public GeneroDTO(Genero genero){
        this.idGenero = genero.getIdGenero();
        this.tipoGenero = genero.getTipoGenero();
    }

    public Long getIdGenero() {
        return this.idGenero;
    }

    public String getTipoGenero() {
        return this.tipoGenero;
    }

}
