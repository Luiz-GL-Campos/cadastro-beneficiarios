package br.gov.incra.cadastrobeneficiarios.form;

import java.util.Collections;
import java.util.List;

public class CadastroBeneficiarioForm {
    private BeneficiarioForm beneficiario;
    private List<ContaForm> contas;
    private List<EmailForm> emails;
    private List<EnderecoForm> enderecos;
    private List<TelefoneForm> telefones;
  
    public BeneficiarioForm getBeneficiario() {
      return this.beneficiario;
    }
  
    public List<ContaForm> getContas() {
      // Esse metodo eu consigo proteger minha listas de contas//
      return Collections.unmodifiableList(this.contas);
    }
  
    public List<EmailForm> getEmails() {
      return Collections.unmodifiableList(this.emails);
    }
  
    public List<EnderecoForm> getEnderecos() {
      return Collections.unmodifiableList(this.enderecos);
    }
  
    public List<TelefoneForm> getTelefones() {
      return Collections.unmodifiableList(this.telefones);
    }

}