package br.gov.incra.cadastrobeneficiarios.service;

import java.util.ArrayList;
import java.util.List;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.service.executor.ExecutorCadastroBeneficiario;
import br.gov.incra.cadastrobeneficiarios.service.executor.ExecutorCadastroConta;
import br.gov.incra.cadastrobeneficiarios.service.executor.ExecutorCadastroEmail;
import br.gov.incra.cadastrobeneficiarios.service.executor.ExecutorCadastroEndereco;
import br.gov.incra.cadastrobeneficiarios.service.executor.ExecutorCadastroTelefone;

public class CadastroBeneficiarioService {

    private List<AcaoCadastroBeneficiario> acoes = new ArrayList<>();
    private final ExecutorCadastroBeneficiario beneficiario;
    private final ExecutorCadastroConta conta;
    private final ExecutorCadastroEmail email;
    private final ExecutorCadastroEndereco endereco;
    private final ExecutorCadastroTelefone telefone;

    public CadastroBeneficiarioService(ExecutorCadastroBeneficiario beneficiario, ExecutorCadastroConta conta, 
        ExecutorCadastroEmail email, ExecutorCadastroEndereco endereco, ExecutorCadastroTelefone telefone
    ) {
        this.beneficiario = beneficiario;
        this.conta = conta;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        adicinaAcoes();
    }
    
    public String cadastrar(CadastroBeneficiarioForm cadastroBeneficiarioForm) {
        acoes.forEach(acao -> acao.executa(cadastroBeneficiarioForm));
        return cadastroBeneficiarioForm.getBeneficiario().getCpf();
    }

    private void adicinaAcoes() {
        acoes.clear();
        acoes.add(beneficiario);
        acoes.add(conta);
        acoes.add(email);
        acoes.add(endereco);
        acoes.add(telefone);
    }
}
