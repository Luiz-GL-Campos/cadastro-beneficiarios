package br.gov.incra.cadastrobeneficiarios.service.executor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.form.ContaForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.Conta;
import br.gov.incra.cadastrobeneficiarios.model.repository.ContaRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

@Service
public class ExecutorCadastroConta implements AcaoCadastroBeneficiario {

    private final ContaRepository contaRepository;

    public ExecutorCadastroConta(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public void executa(CadastroBeneficiarioForm form) {
        List<Conta> listaConta = new ArrayList<>();
        for (ContaForm conta : form.getContas()) {
            listaConta.add(new Conta(conta, form.getBeneficiario()));
        }
        contaRepository.saveAll(listaConta);
        
    }
    
}
