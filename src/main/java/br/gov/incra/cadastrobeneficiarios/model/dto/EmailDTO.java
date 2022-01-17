package br.gov.incra.cadastrobeneficiarios.model.dto;

import br.gov.incra.cadastrobeneficiarios.model.entity.Email;

public class EmailDTO {
    private Long idEmail;
    private String enderecoEmail;
    
    public EmailDTO(Email email){
        this.idEmail = email.getIdEmail();
        this.enderecoEmail = email.getEnderecoEmail();
    }
}
