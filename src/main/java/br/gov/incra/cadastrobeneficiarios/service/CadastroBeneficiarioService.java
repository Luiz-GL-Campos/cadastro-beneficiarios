package br.gov.incra.cadastrobeneficiarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.model.dto.BeneficiarioDTO;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroBeneficiario;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroConta;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroEmail;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroEndereco;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroMunicipio;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroSituacao;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroTelefone;

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
    
    @Transactional
    public BeneficiarioDTO cadastrar(CadastroBeneficiarioForm cadastroBeneficiarioForm) {
        acoes.forEach(acao -> acao.executa(cadastroBeneficiarioForm));
        return null;
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
