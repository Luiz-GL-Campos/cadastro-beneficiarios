package br.gov.incra.cadastrobeneficiarios.form;

public class EnderecoForm {
    private String cep;
    private String bairro;
    private String endereco;
    private boolean enderecoAtivo;
    private String numero;
    private MunicipioForm municipioForm;

    public String getCep() {
        return this.cep;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public boolean getEnderecoAtivo() {
        return this.enderecoAtivo;
    }

    public boolean isEnderecoAtivo() {
        return this.enderecoAtivo;
    }

    public String getNumero() {
        return this.numero;
    }

    public MunicipioForm getMunicipioForm() {
        return this.municipioForm;
    }

}
