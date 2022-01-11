package br.gov.incra.cadastrobeneficiarios.form;

public class ContaForm {
    private String agencia;
    private String numeroConta;
    private Long idTipoConta;
    private Long codBanco;

    public String getAgencia() {
        return this.agencia;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public Long getIdTipoConta() {
        return this.idTipoConta;
    }

    public Long getCodBanco() {
        return this.codBanco;
    }

}
