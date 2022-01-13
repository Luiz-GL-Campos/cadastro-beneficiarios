package br.gov.incra.cadastrobeneficiarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.service.executor.ExecutorCadastroBeneficiario;
import br.gov.incra.cadastrobeneficiarios.service.executor.ExecutorCadastroConta;
import br.gov.incra.cadastrobeneficiarios.service.executor.ExecutorCadastroEmail;
import br.gov.incra.cadastrobeneficiarios.service.executor.ExecutorCadastroEndereco;
import br.gov.incra.cadastrobeneficiarios.service.executor.ExecutorCadastroMunicipio;
import br.gov.incra.cadastrobeneficiarios.service.executor.ExecutorCadastroSituacao;
import br.gov.incra.cadastrobeneficiarios.service.executor.ExecutorCadastroTelefone;

@Service
public class CadastroBeneficiarioService {

    private List<AcaoCadastroBeneficiario> acoes = new ArrayList<>();
    private final ExecutorCadastroBeneficiario beneficiario;
    private final ExecutorCadastroConta conta;
    private final ExecutorCadastroEmail email;
    private final ExecutorCadastroMunicipio municipio;
    private final ExecutorCadastroEndereco endereco;
    private final ExecutorCadastroTelefone telefone;
    private final ExecutorCadastroSituacao situacao;

    public CadastroBeneficiarioService(ExecutorCadastroBeneficiario beneficiario, ExecutorCadastroConta conta, 
        ExecutorCadastroEmail email, ExecutorCadastroMunicipio municipio, ExecutorCadastroEndereco endereco, ExecutorCadastroTelefone telefone,
        ExecutorCadastroSituacao situacao
    ) {
        this.beneficiario = beneficiario;
        this.conta = conta;
        this.email = email;
        this.municipio = municipio;
        this.endereco = endereco;
        this.telefone = telefone;
        this.situacao = situacao;
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
        acoes.add(municipio);
        acoes.add(endereco);
        acoes.add(telefone);
        acoes.add(situacao);
    }
}
