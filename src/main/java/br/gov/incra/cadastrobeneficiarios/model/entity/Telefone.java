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
import br.gov.incra.cadastrobeneficiarios.form.TelefoneForm;

@Entity
@Table(name = "telefone", schema = "beneficiario")
public class Telefone {
    @Id
    @Column(name = "id_telefone")
    @SequenceGenerator(name = "beneficiario.id_telefone_seq", sequenceName = "beneficiario.id_telefone_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "beneficiario.id_telefone_seq", strategy = GenerationType.SEQUENCE)
    private Long idTelefone;
    @Column(name = "numero_telefone")
    private String numeroTelefone;
    @Column(name = "telefone_ativo")
    private Boolean ativo;
    @Column(name = "cpf_beneficiario")
    private String cpf;
    @Column(name = "id_tipo_telefone")
    private Long idTipoTelefone;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_beneficiario", insertable = false, updatable = false)
    private Beneficiario beneficiario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_telefone", insertable = false, updatable = false)
    private TipoTelefone tipoTelefone;
    
    public Telefone () {}

    public Telefone(String numeroTelefone, Boolean ativo, Long idTipoTelefone, String cpf) {
        this.numeroTelefone = numeroTelefone;
        this.ativo = ativo;
        this.idTipoTelefone = idTipoTelefone;
        this.cpf = cpf;
    }

    public Telefone(TelefoneForm telefone, BeneficiarioForm beneficiarioForm) {
        this.numeroTelefone = telefone.getNumeroTelefone();
        this.ativo = telefone.getTelefoneAtivo();
        this.idTipoTelefone = telefone.getIdTipoTelefone();
        this.cpf = beneficiarioForm.getCpf();
    }

    public String getNumeroTelefone() {
        return this.numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Boolean setAtivo() {
        return this.ativo;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Long getIdTelefone() {
        return this.idTelefone;
    }

    public TipoTelefone getTipoTelefone() {
        return this.tipoTelefone;
    }
}
