package br.gov.incra.cadastrobeneficiarios.service.executor;

import java.util.ArrayList;
import java.util.List;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.form.TelefoneForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.Telefone;
import br.gov.incra.cadastrobeneficiarios.model.repository.TelefoneRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

public class ExecutorCadastroTelefone implements AcaoCadastroBeneficiario {

    private final TelefoneRepository telefoneRepository;

    public ExecutorCadastroTelefone(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    @Override
    public void executa(CadastroBeneficiarioForm form) {
        List<Telefone> listaTelefone = new ArrayList<>();
        for (TelefoneForm telefone : form.getTelefones()) {
            listaTelefone.add(new Telefone(telefone));
        }
        telefoneRepository.saveAll(listaTelefone);
    }
    
}
