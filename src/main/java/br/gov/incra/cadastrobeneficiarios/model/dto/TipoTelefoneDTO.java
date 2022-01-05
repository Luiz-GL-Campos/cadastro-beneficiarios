package br.gov.incra.cadastrobeneficiarios.model.dto;

import br.gov.incra.cadastrobeneficiarios.model.entity.TipoTelefone;

public class TipoTelefoneDTO {
    private Long idTipoTelefone;
    private String descricaoTipoTelefone;

    public TipoTelefoneDTO(TipoTelefone tipoTelefone){
        this.idTipoTelefone = tipoTelefone.getIdTipoTelefone();
        this.descricaoTipoTelefone = tipoTelefone.getDescricaoTipoTelefone();
    }

    public Long getIdTipoTelefone() {
        return this.idTipoTelefone;
    }

    public String getDescricaoTipoTelefone() {
        return this.descricaoTipoTelefone;
    }

}
