package br.gov.incra.cadastrobeneficiarios.model.dto;

import br.gov.incra.cadastrobeneficiarios.model.entity.TipoConta;

public class TipoContaDTO {
    private Long idTipoConta;
    private String tipoConta;

    public TipoContaDTO(TipoConta tipoConta){
        this.idTipoConta = tipoConta.getIdTipoConta();
        this.tipoConta = tipoConta.getTipoConta();
    }

    public Long getIdTipoConta() {
        return this.idTipoConta;
    }

    public String getTipoConta() {
        return this.tipoConta;
    }

}
