package br.gov.incra.cadastrobeneficiarios.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.incra.cadastrobeneficiarios.form.BeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.form.EmailForm;

@Entity
@Table(name = "email", schema = "beneficiario")
public class Email {

    @Id
    @Column(name = "id_email")
    @SequenceGenerator(name = "beneficiario.id_email_seq", sequenceName = "beneficiario.id_email_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "beneficiario.id_email_seq", strategy = GenerationType.SEQUENCE)
    private Long idEmail;

    @Column(name = "enderenco_email")
    private String enderecoEmail;

    @Column(name = "cpf_beneficiario")
    private String cpf;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_beneficiario", insertable = false, updatable = false)
    private Beneficiario cpfBeneficiario;
    
    public Email(){}

    public Email(String enderecoEmail, String cpf) {
        this.enderecoEmail = enderecoEmail;
        this.cpf = cpf;
    }
    
    public Email(EmailForm email, BeneficiarioForm beneficiarioForm){
        this.enderecoEmail = email.getEnderecoEmail();
        this.cpf = beneficiarioForm.getCpf();
    }

    public Long getIdEmail() {
        return this.idEmail;
    }

    public void setIdEmail(Long idEmail) {
        this.idEmail = idEmail;
    }

    public String getEnderecoEmail() {
        return this.enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Beneficiario getCpfBeneficiario() {
        return this.cpfBeneficiario;
    }

    public void setCpfBeneficiario(Beneficiario cpfBeneficiario) {
        this.cpfBeneficiario = cpfBeneficiario;
    }

}
