package br.gov.incra.cadastrobeneficiarios.model.builder;

import br.gov.incra.cadastrobeneficiarios.model.entity.Conta;

public class ContaBuilder implements Builder<Conta> {
    
    private String agencia;
    private String numeroConta;
    private Long idTipoConta;
    private Long codBanco;
    private String cpfBeneficiario;


    public ContaBuilder agencia(String agencia){
        this.agencia = agencia;
        return this;
    }

    public ContaBuilder numeroConta(String numeroConta){
        this.numeroConta = numeroConta;
        return this;
    }

    public ContaBuilder idTipoConta(Long idTipoConta){
        this.idTipoConta = idTipoConta;
        return this;
    }

    public ContaBuilder codBanco(Long codBanco){
        this.codBanco = codBanco;
        return this;
    }

    public ContaBuilder cpfBeneficiario(String cpfBeneficiario){
        this.cpfBeneficiario = cpfBeneficiario;
        return this;
    }

    @Override
    public Conta Build() {
        return new Conta(agencia,numeroConta,idTipoConta,codBanco,cpfBeneficiario);
    }
}
