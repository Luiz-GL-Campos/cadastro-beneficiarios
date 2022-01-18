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
import br.gov.incra.cadastrobeneficiarios.form.ContaForm;

@Entity
@Table(name = "conta", schema = "beneficiario")
public class Conta {
    
    @Id
    @Column(name = "id_conta")
    @SequenceGenerator(name = "beneficiario.id_conta_seq", sequenceName = "beneficiario.id_conta_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "beneficiario.id_conta_seq", strategy = GenerationType.SEQUENCE)
    private Long idConta;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "numero_conta")
    private String numeroConta;
    @Column(name = "id_tipo_conta")
    private Long idTipoConta;
    @Column(name = "cod_banco")
    private Long codBanco;
    @Column(name = "cpf_beneficiario")
    private String cpf;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_conta", insertable = false, updatable = false)
    private TipoConta tipoConta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_banco", insertable = false, updatable = false)
    private Banco banco;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_beneficiario", insertable = false, updatable = false)
    private Beneficiario beneficiario;
    
    public Conta() {}

    public Conta(
        String agencia,
        String numeroConta,
        Long idTipoConta,
        Long codBanco,
        String cpfBeneficiario){
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.idTipoConta = idTipoConta;
        this.codBanco = codBanco;
        this.cpf = cpfBeneficiario;
    }

    public Conta(ContaForm conta, BeneficiarioForm beneficiarioForm) {
        this.agencia = conta.getAgencia();
        this.numeroConta = conta.getNumeroConta();
        this.idTipoConta = conta.getIdTipoConta();
        this.codBanco = conta.getCodBanco();
        this.cpf = beneficiarioForm.getCpf();
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Long getIdConta() {
        return this.idConta;
    }

    public String getCpf() {
        return this.cpf;
    }

    public TipoConta getTipoConta() {
        return this.tipoConta;
    }

    public Banco getBanco() {
        return this.banco;
    }

    public Beneficiario getBeneficiario() {
        return this.beneficiario;
    }
    

}
