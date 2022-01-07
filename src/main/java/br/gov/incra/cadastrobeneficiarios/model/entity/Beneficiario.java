package br.gov.incra.cadastrobeneficiarios.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "beneficiario", schema = "beneficiario")
public class Beneficiario {
    @Id
    @Column(name = "cpf_beneficiario")
    String cpfBeneficiario;

    @Column(name = "nome_beneficiario")
    String nomeBeneficiario;

    @Column(name = "data_nascimento_beneficiario")
    LocalDate dataNascimentoBeneficiario;

    @Column(name = "numero_rg_beneficiario")
    Long numeroRgBeneficiario;

    @Column(name = "orgao_emissor_rg")
    String orgaoEmissorRg;

    @Column(name = "data_emissao_rg")
    LocalDate dataEmissaoRg;

    @Column(name = "nome_assentamento")
    String nomeAssentamento;

    @Column(name = "id_genero")
    Long idGenero;

    @Column(name = "id_escolaridade")
    Long idEscolaridade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero", insertable = false, updatable = false)
    private Genero genero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_escolaridade", insertable = false, updatable = false)
    private Genero escolaridade;


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

    public Genero getEscolaridade() {
        return this.escolaridade;
    }

    public void setEscolaridade(Genero escolaridade) {
        this.escolaridade = escolaridade;
    }


    public Beneficiario(){}

    public Beneficiario(
        String cpfBeneficiario, 
        String nomeBeneficiario, 
        LocalDate dataNascimentoBeneficiario, 
        Long numeroRgBeneficiario, 
        String orgaoEmissorRg, 
        LocalDate dataEmissaoRg, 
        String nomeAssentamento, 
        Long idGenero, 
        Long idEscolaridade
    ) {
        this.cpfBeneficiario = cpfBeneficiario;
        this.nomeBeneficiario = nomeBeneficiario;
        this.dataNascimentoBeneficiario = dataNascimentoBeneficiario;
        this.numeroRgBeneficiario = numeroRgBeneficiario;
        this.orgaoEmissorRg = orgaoEmissorRg;
        this.dataEmissaoRg = dataEmissaoRg;
        this.nomeAssentamento = nomeAssentamento;
        this.idGenero = idGenero;
        this.idEscolaridade = idEscolaridade;
    }
    
}
