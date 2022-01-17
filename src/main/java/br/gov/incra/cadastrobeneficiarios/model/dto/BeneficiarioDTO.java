package br.gov.incra.cadastrobeneficiarios.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;
import br.gov.incra.cadastrobeneficiarios.model.entity.SituacaoBeneficiario;

public class BeneficiarioDTO {
    private String cpfBeneficiario;
    private String nomeBeneficiario; 
    private LocalDate dataNascimentoBeneficiario; 
    private Long numeroRgBeneficiario;
    private String orgaoEmissorRg;
    private LocalDate dataEmissaoRg; 
    private GeneroDTO generoDTO;
    private EscolaridadeDTO escolaridadeDTO;
    private List<ContaDTO> contas = new ArrayList<>();
    private List<EmailDTO> emails = new ArrayList<>();
    private List<EnderecoDTO> enderecos = new ArrayList<>();
    private List<TelefoneDTO> telefones = new ArrayList<>();
    private List<SituacaoBeneficiarioDTO> situacoes = new ArrayList<>();

    public BeneficiarioDTO(){}

    public BeneficiarioDTO(Beneficiario beneficiario) {
        this.cpfBeneficiario = beneficiario.getCpfBeneficiario();
        this.nomeBeneficiario = beneficiario.getNomeBeneficiario();
        this.dataNascimentoBeneficiario = beneficiario.getDataNascimentoBeneficiario();
        this.numeroRgBeneficiario = beneficiario.getNumeroRgBeneficiario();
        this.orgaoEmissorRg = beneficiario.getOrgaoEmissorRg();
        this.dataEmissaoRg = beneficiario.getDataEmissaoRg();
        this.generoDTO = new GeneroDTO(beneficiario.getGenero());
        this.escolaridadeDTO = new EscolaridadeDTO(beneficiario.getEscolaridade());
        beneficiario.getContas().forEach(conta -> contas.add(new ContaDTO(conta)));
        beneficiario.getEmails().forEach(email -> emails.add(new EmailDTO(email)));
        beneficiario.getEnderecos().forEach(endereco -> enderecos.add(new EnderecoDTO(endereco)));
        beneficiario.getTelefones().forEach(telefone -> telefones.add(new TelefoneDTO(telefone)));
    }

    public void adicionaSituacao(SituacaoBeneficiario situacaoBeneficiario){
        situacoes.add(new SituacaoBeneficiarioDTO(situacaoBeneficiario));
    }


    public String getCpfBeneficiario() {
        return this.cpfBeneficiario;
    }

    public String getNomeBeneficiario() {
        return this.nomeBeneficiario;
    }

    public LocalDate getDataNascimentoBeneficiario() {
        return this.dataNascimentoBeneficiario;
    }

    public Long getNumeroRgBeneficiario() {
        return this.numeroRgBeneficiario;
    }

    public String getOrgaoEmissorRg() {
        return this.orgaoEmissorRg;
    }

    public LocalDate getDataEmissaoRg() {
        return this.dataEmissaoRg;
    }

    public GeneroDTO getGeneroDTO() {
        return this.generoDTO;
    }

    public EscolaridadeDTO getEscolaridadeDTO() {
        return this.escolaridadeDTO;
    }

    public List<ContaDTO> getContas() {
        return this.contas;
    }

    public List<EmailDTO> getEmails() {
        return this.emails;
    }

    public List<EnderecoDTO> getEnderecos() {
        return this.enderecos;
    }

    public List<TelefoneDTO> getTelefones() {
        return this.telefones;
    }

    public List<SituacaoBeneficiarioDTO> getSituacoes() {
        return this.situacoes;
    }

}
