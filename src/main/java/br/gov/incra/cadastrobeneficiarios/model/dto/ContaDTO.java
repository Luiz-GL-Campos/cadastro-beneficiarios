package br.gov.incra.cadastrobeneficiarios.model.dto;

import br.gov.incra.cadastrobeneficiarios.model.entity.Conta;

public class ContaDTO {
    private Long idConta;
    private String agencia;
    private String numeroConta;
    private TipoContaDTO tipoContaDTO;
    private BancoDTO bancoDTO;
    
    public ContaDTO(Conta conta) {
        this.idConta = conta.getIdConta();
        this.agencia = conta.getAgencia();
        this.numeroConta = conta.getNumeroConta();
        this.tipoContaDTO = new TipoContaDTO(conta.getTipoConta());
        this.bancoDTO = new BancoDTO(conta.getBanco());
    }
}
