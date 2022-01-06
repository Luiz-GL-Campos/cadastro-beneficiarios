package br.gov.incra.cadastrobeneficiarios.model.builder;

import java.time.LocalDate;

import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;

public class BeneficiarioBuilder implements Builder<Beneficiario> {

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Long rg;
    private String orgaoEmissor;
    private LocalDate dataEmissao;
    private String assentamento;
    private Long idGenero;
    private Long idEscolaridade;

    public BeneficiarioBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public BeneficiarioBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public BeneficiarioBuilder dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public BeneficiarioBuilder rg(Long rg) {
        this.rg = rg;
        return this;
    }

    public BeneficiarioBuilder orgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
        return this;
    }

    public BeneficiarioBuilder dataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
        return this;
    }

    public BeneficiarioBuilder assentamento(String assentamento) {
        this.assentamento = assentamento;
        return this;
    }

    public BeneficiarioBuilder idGenero(Long idGenero) {
        this.idGenero = idGenero;
        return this;
    }

    public BeneficiarioBuilder idEscolaridade(Long idEscolaridade) {
        this.idEscolaridade = idEscolaridade;
        return this;
    }

    @Override
    public Beneficiario Build() {
        return new Beneficiario(
            cpf, 
            nome, 
            dataNascimento, 
            rg, 
            orgaoEmissor, 
            dataEmissao, 
            assentamento, 
            idGenero, 
            idEscolaridade
        );
    }
    
}
