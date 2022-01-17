package br.gov.incra.cadastrobeneficiarios.model.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.gov.incra.cadastrobeneficiarios.form.BeneficiarioForm;

@Entity
@Table(name = "beneficiario", schema = "beneficiario")
public class Beneficiario {
    @Id
    @Column(name = "cpf_beneficiario")
    private String cpfBeneficiario;
    @Column(name = "nome_beneficiario")
    private String nomeBeneficiario;
    @Column(name = "data_nascimento_beneficiario")
    private LocalDate dataNascimentoBeneficiario;
    @Column(name = "numero_rg_beneficiario")
    private Long numeroRgBeneficiario;
    @Column(name = "orgao_emissor_rg")
    private String orgaoEmissorRg;
    @Column(name = "data_emissao_rg")
    private LocalDate dataEmissaoRg;
    @Column(name = "nome_assentamento")
    private String nomeAssentamento;
    @Column(name = "id_genero")
    private Long idGenero;
    @Column(name = "id_escolaridade")
    private Long idEscolaridade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero", insertable = false, updatable = false)
    private Genero genero;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_escolaridade", insertable = false, updatable = false)
    private Escolaridade escolaridade;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficiario")
    private List<Conta> contas;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficiario")
    private List<Endereco> enderecos;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficiario")
    private List<Email> emails;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficiario")
    private List<Telefone> telefones;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficiario")
    private List<SituacaoBeneficiario> situacoes;

    public Beneficiario(){}

    public Beneficiario(String cpf, String nome, LocalDate dataNascimento, Long rg, String orgaoEmissor, LocalDate dataEmissao, String assentamento, Long idGenero, Long idEscolaridade){}

    public Beneficiario(
        String cpfBeneficiario, 
        String nomeBeneficiario, 
        LocalDate dataNascimentoBeneficiario, 
        Long numeroRgBeneficiario, 
        String orgaoEmissorRg, 
        LocalDate dataEmissaoRg,  
        Long idGenero, 
        Long idEscolaridade
    ) {
        this.cpfBeneficiario = cpfBeneficiario;
        this.nomeBeneficiario = nomeBeneficiario;
        this.dataNascimentoBeneficiario = dataNascimentoBeneficiario;
        this.numeroRgBeneficiario = numeroRgBeneficiario;
        this.orgaoEmissorRg = orgaoEmissorRg;
        this.dataEmissaoRg = dataEmissaoRg;
        this.idGenero = idGenero;
        this.idEscolaridade = idEscolaridade;
    }

    public Beneficiario(BeneficiarioForm beneficiario) {
        this.cpfBeneficiario = beneficiario.getCpf();
        this.nomeBeneficiario = beneficiario.getNome();
        this.dataNascimentoBeneficiario = beneficiario.getDataNascimento();
        this.numeroRgBeneficiario = beneficiario.getRg();
        this.orgaoEmissorRg = beneficiario.getOrgaoEmissor();
        this.dataEmissaoRg = beneficiario.getDataEmissao();
        this.idGenero = beneficiario.getIdGenero();
        this.idEscolaridade = beneficiario.getIdEscolaridade();
    }

    public String getCpfBeneficiario() {
        return this.cpfBeneficiario;
    }

    public void setCpfBeneficiario(String cpfBeneficiario) {
        this.cpfBeneficiario = cpfBeneficiario;
    }

    public String getNomeBeneficiario() {
        return this.nomeBeneficiario;
    }

    public void setNomeBeneficiario(String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }

    public LocalDate getDataNascimentoBeneficiario() {
        return this.dataNascimentoBeneficiario;
    }

    public void setDataNascimentoBeneficiario(LocalDate dataNascimentoBeneficiario) {
        this.dataNascimentoBeneficiario = dataNascimentoBeneficiario;
    }

    public Long getNumeroRgBeneficiario() {
        return this.numeroRgBeneficiario;
    }

    public void setNumeroRgBeneficiario(Long numeroRgBeneficiario) {
        this.numeroRgBeneficiario = numeroRgBeneficiario;
    }

    public String getOrgaoEmissorRg() {
        return this.orgaoEmissorRg;
    }

    public void setOrgaoEmissorRg(String orgaoEmissorRg) {
        this.orgaoEmissorRg = orgaoEmissorRg;
    }

    public LocalDate getDataEmissaoRg() {
        return this.dataEmissaoRg;
    }

    public void setDataEmissaoRg(LocalDate dataEmissaoRg) {
        this.dataEmissaoRg = dataEmissaoRg;
    }

    public String getNomeAssentamento() {
        return this.nomeAssentamento;
    }

    public void setNomeAssentamento(String nomeAssentamento) {
        this.nomeAssentamento = nomeAssentamento;
    }

    public Long getIdGenero() {
        return this.idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public Long getIdEscolaridade() {
        return this.idEscolaridade;
    }

    public void setIdEscolaridade(Long idEscolaridade) {
        this.idEscolaridade = idEscolaridade;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Escolaridade getEscolaridade() {
        return this.escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public List<Conta> getContas() {
        return this.contas;
    }

    public List<Email> getEmails() {
        return this.emails;
    }

    public List<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public List<Telefone> getTelefones() {
        return this.telefones;
    }

    public List<SituacaoBeneficiario> getSituacaoBeneficiairio() {
        return this.situacoes;
    }

    
}
