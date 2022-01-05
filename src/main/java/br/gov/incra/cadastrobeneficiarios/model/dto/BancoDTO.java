package br.gov.incra.cadastrobeneficiarios.model.dto;

import br.gov.incra.cadastrobeneficiarios.model.entity.Banco;

public class BancoDTO {
    private Long codBanco;
    private String nomeBanco;

    public BancoDTO(Banco banco) {
        this.codBanco = banco.getCodBanco();
        this.nomeBanco = banco.getNomeBanco();
    }

    public Long getCodBanco() {
        return this.codBanco;
    }

    public String getNomeBanco() {
        return this.nomeBanco;
    }

}
