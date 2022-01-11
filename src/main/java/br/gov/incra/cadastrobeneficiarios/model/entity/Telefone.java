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

import br.gov.incra.cadastrobeneficiarios.form.TelefoneForm;

@Entity
@Table(name = "TELEFONE", schema = "BENEFICIARIO")
public class Telefone {
    @Id
    @Column(name = "ID_TELEFONE")
    @SequenceGenerator(name = "BENEFICIARIO.ID_TELEFONE_SEQ", sequenceName = "BENEFICIARIO.ID_TELEFONE_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "BENEFICIARIO.ID_TELEFONE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long idTelefone;
    @Column(name = "NUMERO_TELEFONE")
    private String numeroTelefone;
    @Column(name = "ATIVO")
    private Boolean ativo;
    @Column(name = "ID_TIPO_TELEFONE")
    private Long idTipoTelefone;
    @Column(name = "CPF")
    private String cpf;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_TELEFONE", insertable = false, updatable = false)
    private TipoTelefone tipoTelefone;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CPF", insertable = false, updatable = false)
    private Beneficiario beneficiario;

    public Telefone () {}

    public Telefone(String numeroTelefone, Boolean ativo, Long idTipoTelefone, String cpf) {
        this.numeroTelefone = numeroTelefone;
        this.ativo = ativo;
        this.idTipoTelefone = idTipoTelefone;
        this.cpf = cpf;
    }

    public Telefone(TelefoneForm telefone) {
        this.numeroTelefone = telefone.getNumeroTelefone();
        this.ativo = telefone.getTelefoneAtivo();
        this.idTipoTelefone = telefone.getIdTipoTelefone();
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
}
