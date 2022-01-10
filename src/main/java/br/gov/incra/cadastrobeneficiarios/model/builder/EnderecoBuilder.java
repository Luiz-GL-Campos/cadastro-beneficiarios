package br.gov.incra.cadastrobeneficiarios.model.builder;

import br.gov.incra.cadastrobeneficiarios.model.entity.Endereco;

public class EnderecoBuilder implements Builder<Endereco> {
    private String cep;
    private String bairro;
    private String endereco;
    private Boolean enderecoAtivo;
    private String numero;
    private String cpfBeneficiario;
    private Long idMunicipio;

    public EnderecoBuilder cep(String cep){
        this.cep = cep;
        return this;
    }
    
    public EnderecoBuilder bairro(String bairro){
        this.bairro = bairro;
        return this;
    }

    public EnderecoBuilder endereco(String endereco){
        this.endereco = endereco;
        return this;
    }

    public EnderecoBuilder enderecoAtivo(Boolean enderecoAtivo){
        this.enderecoAtivo = enderecoAtivo;
        return this;
    }

    public EnderecoBuilder numero(String numero){
        this.numero = numero;
        return this;
    }

    public EnderecoBuilder cpfBeneficiario(String cpfBeneficiario){
        this.cpfBeneficiario = cpfBeneficiario;
        return this;
    }

    public EnderecoBuilder idMunicipio(Long idMunicipio){
        this.idMunicipio = idMunicipio;
        return this;
    }

    @Override
    public Endereco Build() {
        return new Endereco(cep, bairro, endereco, enderecoAtivo,numero, cpfBeneficiario, idMunicipio);
    }
}
