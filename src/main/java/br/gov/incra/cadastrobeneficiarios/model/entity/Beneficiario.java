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
