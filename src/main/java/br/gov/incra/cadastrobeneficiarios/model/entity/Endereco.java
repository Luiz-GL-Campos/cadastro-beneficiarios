package br.gov.incra.cadastrobeneficiarios.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.incra.cadastrobeneficiarios.form.EnderecoForm;

@Entity
@Table(name = "endereco", schema = "beneficiario")
public class Endereco {
    @Id
    @Column(name = "id_endereco")
    @SequenceGenerator(name = "beneficiario.id_endereco_seq", sequenceName = "beneficiario.id_endereco_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "beneficiario.id_endereco_seq", strategy = GenerationType.SEQUENCE)
    private Long idEndereco;
    @Column(name = "cep")
    private String cep;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "endereco_ativo")
    private Boolean enderecoAtivo;
    @Column(name = "numero")
    private String numero;
    @Column(name = "cpf_beneficiario")
    private String cpfBeneficiario;
    @Column(name = "id_municipio")
    private Long idMunicipio;

    public Endereco() {}

    public Endereco(
        String cep, 
        String bairro, 
        String endereco, 
        Boolean enderecoAtivo, 
        String numero, 
        String cpfBeneficiario, 
        Long idMunicipio) {
        this.cep = cep;
        this.bairro = bairro;
        this.endereco = endereco;
        this.enderecoAtivo = enderecoAtivo;
        this.numero = numero;
        this.cpfBeneficiario = cpfBeneficiario;
        this.idMunicipio = idMunicipio;
    }


    public Endereco(EnderecoForm enderecoForm) {
        this.cep = enderecoForm.getCep();
        this.bairro = enderecoForm.getBairro();
        this.endereco = enderecoForm.getEndereco();
        this.enderecoAtivo = enderecoForm.getEnderecoAtivo();
        this.numero = enderecoForm.getNumero();
        this.idMunicipio = enderecoForm.getMunicipioForm().getIdMunicipio();
    }

    public Long getIdEndereco() {
        return this.idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Boolean isEnderecoAtivo() {
        return this.enderecoAtivo;
    }

    public Boolean getEnderecoAtivo() {
        return this.enderecoAtivo;
    }

    public void setEnderecoAtivo(Boolean enderecoAtivo) {
        this.enderecoAtivo = enderecoAtivo;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCpfBeneficiario() {
        return this.cpfBeneficiario;
    }

    public void setCpfBeneficiario(String cpfBeneficiario) {
        this.cpfBeneficiario = cpfBeneficiario;
    }

    public Long getIdMunicipio() {
        return this.idMunicipio;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

}
