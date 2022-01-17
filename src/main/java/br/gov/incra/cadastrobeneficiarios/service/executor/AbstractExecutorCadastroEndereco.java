package br.gov.incra.cadastrobeneficiarios.service.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.Endereco;
import br.gov.incra.cadastrobeneficiarios.model.repository.EnderecoRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

public abstract class AbstractExecutorCadastroEndereco implements AcaoCadastroBeneficiario {
    private final EnderecoRepository enderecoRepository;

    public AbstractExecutorCadastroEndereco(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void executa(CadastroBeneficiarioForm form) {
        List<Endereco> novaListaEnderecos = new ArrayList<>();
        form.getEnderecos().forEach(endereco -> novaListaEnderecos.add(new Endereco(endereco, form.getBeneficiario())));

        if(isFuncionalidadeAlteracaoEndereco()) {
            List<Endereco> listaEnderecos = enderecoRepository.findByCpf(form.getBeneficiario().getCpf());
            List<Endereco> diferenca = listaEnderecos.stream().filter(endereco -> !novaListaEnderecos.contains(endereco))
                .collect(Collectors.toList());
            enderecoRepository.deleteAll(diferenca);
        }
        enderecoRepository.saveAll(novaListaEnderecos);
    }

    protected abstract boolean isFuncionalidadeAlteracaoEndereco();
}
