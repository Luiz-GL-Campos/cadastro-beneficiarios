package br.gov.incra.cadastrobeneficiarios.model.dto;

import br.gov.incra.cadastrobeneficiarios.model.entity.Endereco;

public class EnderecoDTO {
    private Long idEndereco;
    private String cep;
    private String bairro;
    private String endereco;
    private Boolean enderecoAtivo;
    private String numero;
    private MunicipioDTO municipio;

    public EnderecoDTO(Endereco endereco){
        this.idEndereco = endereco.getIdEndereco();
        this.cep = endereco.getCep();
        this.bairro = endereco.getBairro();
        this.endereco = endereco.getEndereco();
        this.enderecoAtivo = endereco.getEnderecoAtivo();
        this.numero = endereco.getNumero();
        this.municipio = new MunicipioDTO(endereco.getMunicipio());
    }
}
