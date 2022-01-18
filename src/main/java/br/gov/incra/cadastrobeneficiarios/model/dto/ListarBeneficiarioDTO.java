package br.gov.incra.cadastrobeneficiarios.model.dto;

import java.time.LocalDate;

import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;

public class ListarBeneficiarioDTO {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private GeneroDTO genero;

    public ListarBeneficiarioDTO(Beneficiario beneficiario) {
        this.cpf = beneficiario.getCpfBeneficiario();
        this.nome = beneficiario.getNomeBeneficiario();
        this.dataNascimento = beneficiario.getDataNascimentoBeneficiario();
        this.genero = new GeneroDTO(beneficiario.getGenero());
    }
}
