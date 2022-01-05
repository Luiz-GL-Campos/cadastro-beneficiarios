package br.gov.incra.cadastrobeneficiarios.model.dto;

import br.gov.incra.cadastrobeneficiarios.model.entity.Escolaridade;

public class EscolaridadeDTO {
    private Long idEscolaridade;
    private String nivelEscolaridade;

    public EscolaridadeDTO(Escolaridade escolaridade) {
        this.idEscolaridade = escolaridade.getIdEscolaridade();
        this.nivelEscolaridade = escolaridade.getNivelEscolaridade();
    }

    public Long getIdEscolaridade() {
        return this.idEscolaridade;
    }

    public String getNivelEscolaridade() {
        return this.nivelEscolaridade;
    }

}
