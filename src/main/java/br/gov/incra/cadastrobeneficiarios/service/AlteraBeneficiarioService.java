package br.gov.incra.cadastrobeneficiarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.model.dto.BeneficiarioDTO;
import br.gov.incra.cadastrobeneficiarios.service.executor.altera.ExecutorAlteraBeneficiario;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroConta;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroEmail;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroEndereco;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroMunicipio;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroSituacao;
import br.gov.incra.cadastrobeneficiarios.service.executor.cadastro.ExecutorCadastroTelefone;

@Service
public class AlteraBeneficiarioService {

    private final DetalhaBeneficiarioService detalhaBeneficiarioService;
    private final ExecutorAlteraBeneficiario beneficiario;
    private List<AcaoCadastroBeneficiario> acoes = new ArrayList<>();
    private final ExecutorCadastroConta conta;
    private final ExecutorCadastroEmail email;
    private final ExecutorCadastroMunicipio municipio;
    private final ExecutorCadastroEndereco endereco;
    private final ExecutorCadastroTelefone telefone;
    private final ExecutorCadastroSituacao situacao;


    public AlteraBeneficiarioService(DetalhaBeneficiarioService detalhaBeneficiarioService, ExecutorAlteraBeneficiario beneficiario,
        ExecutorCadastroConta conta, ExecutorCadastroEmail email, ExecutorCadastroMunicipio municipio, ExecutorCadastroEndereco endereco, 
        ExecutorCadastroTelefone telefone, ExecutorCadastroSituacao situacao
    ) {
        this.detalhaBeneficiarioService = detalhaBeneficiarioService;
        this.beneficiario = beneficiario;
        this.conta = conta;
        this.email = email;
        this.municipio = municipio;
        this.endereco = endereco;
        this.telefone = telefone;
        this.situacao = situacao;
        adicionaAcoes();
    }

    public BeneficiarioDTO altera(CadastroBeneficiarioForm cadastroBeneficiarioForm){
        return detalhaBeneficiarioService.obterPor(cadastroBeneficiarioForm.getBeneficiario().getCpf());
    }

    private void adicionaAcoes() {
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
