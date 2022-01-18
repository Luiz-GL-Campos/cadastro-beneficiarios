package br.gov.incra.cadastrobeneficiarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.service.executor.excluir.ExcluirBeneficiario;
import br.gov.incra.cadastrobeneficiarios.service.executor.excluir.ExcluirConta;
import br.gov.incra.cadastrobeneficiarios.service.executor.excluir.ExcluirEmail;
import br.gov.incra.cadastrobeneficiarios.service.executor.excluir.ExcluirEndereco;
import br.gov.incra.cadastrobeneficiarios.service.executor.excluir.ExcluirSituacao;
import br.gov.incra.cadastrobeneficiarios.service.executor.excluir.ExcluirTelefone;

@Service
public class ExcluirBeneficiarioService {

    private List<AcaoExcluirBeneficiario> acoes = new ArrayList<>();
    private final ExcluirEmail email;
    private final ExcluirTelefone telefone;
    private final ExcluirConta conta;
    private final ExcluirEndereco endereco;
    private final ExcluirSituacao situacao;
    private final ExcluirBeneficiario excluirBeneficiario;
    
    public ExcluirBeneficiarioService(ExcluirEmail email, ExcluirTelefone telefone,
        ExcluirConta conta, ExcluirEndereco endereco, ExcluirSituacao situacao,
        ExcluirBeneficiario excluirBeneficiario
    ) {
        this.email = email;
        this.telefone = telefone;
        this.conta = conta;
        this.endereco = endereco;
        this.situacao = situacao;
        this.excluirBeneficiario = excluirBeneficiario;
        adicionaAcoes();
    }

    public String excluir(String cpf){
        return cpf;
    }

    private void adicionaAcoes() {
        acoes.clear();
        acoes.add(email);
        acoes.add(telefone);
        acoes.add(conta);
        acoes.add(endereco);
        acoes.add(situacao);
        acoes.add(excluirBeneficiario);
    }

}
