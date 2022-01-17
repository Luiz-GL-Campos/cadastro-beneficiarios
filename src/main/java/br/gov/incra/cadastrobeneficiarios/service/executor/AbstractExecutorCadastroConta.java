package br.gov.incra.cadastrobeneficiarios.service.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.Conta;
import br.gov.incra.cadastrobeneficiarios.model.repository.ContaRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

public abstract class AbstractExecutorCadastroConta implements AcaoCadastroBeneficiario {
    private final ContaRepository contaRepository;
    
    public AbstractExecutorCadastroConta(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public void executa(CadastroBeneficiarioForm form){
        List<Conta> novaListaContas = new ArrayList<>();
        form.getContas().forEach(conta -> novaListaContas.add(new Conta(conta, form.getBeneficiario())));

        if (isFuncionalidadeAlteracaoConta()){
            List<Conta> listaContas = contaRepository.findByCpf(form.getBeneficiario().getCpf());
            List<Conta> diferenca = listaContas.stream().filter(email -> !novaListaContas.contains(email)).collect(Collectors.toList());
            contaRepository.deleteAll(diferenca);
        }

        contaRepository.saveAll(novaListaContas);
    }

    protected abstract boolean isFuncionalidadeAlteracaoConta();
}

