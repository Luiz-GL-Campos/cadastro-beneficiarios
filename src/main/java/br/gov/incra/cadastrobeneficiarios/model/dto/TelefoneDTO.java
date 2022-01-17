package br.gov.incra.cadastrobeneficiarios.model.dto;

import br.gov.incra.cadastrobeneficiarios.model.entity.Telefone;

public class TelefoneDTO {
    private Long idTelefone;
    private String numeroTelefone;
    private Boolean ativo;
    private TipoTelefoneDTO tipoTelefoneDTO;

    public TelefoneDTO(Telefone telefone) {
        this.idTelefone = telefone.getIdTelefone();
        this.numeroTelefone = telefone.getNumeroTelefone();
        this.ativo = telefone.getAtivo();
        this.tipoTelefoneDTO = new TipoTelefoneDTO(telefone.getTipoTelefone());
    }
}
