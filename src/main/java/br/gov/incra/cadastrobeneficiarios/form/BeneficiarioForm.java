package br.gov.incra.cadastrobeneficiarios.form;

import java.time.LocalDate;

public class BeneficiarioForm {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Long rg;
    private String orgaoEmissor;
    private LocalDate dataEmissao;
    private Long idGenero;
    private Long idEscolaridade;

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public Long getRg() {
        return this.rg;
    }

    public String getOrgaoEmissor() {
        return this.orgaoEmissor;
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    public Long getIdGenero() {
        return this.idGenero;
    }

    public Long getIdEscolaridade() {
        return this.idEscolaridade;
    }

}
