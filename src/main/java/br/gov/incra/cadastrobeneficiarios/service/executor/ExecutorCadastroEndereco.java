package br.gov.incra.cadastrobeneficiarios.service.executor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.form.EnderecoForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.Endereco;
import br.gov.incra.cadastrobeneficiarios.model.repository.EnderecoRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

@Service
public class ExecutorCadastroEndereco implements AcaoCadastroBeneficiario{

    private final EnderecoRepository enderecoRepository;

    public ExecutorCadastroEndereco(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public void executa(CadastroBeneficiarioForm form) {
        List<Endereco> listaEndereco = new ArrayList<>();
        for (EnderecoForm endereco : form.getEnderecos()) {
            listaEndereco.add(new Endereco(endereco, form.getBeneficiario()));
        }
        enderecoRepository.saveAll(listaEndereco);
    }
    
}
