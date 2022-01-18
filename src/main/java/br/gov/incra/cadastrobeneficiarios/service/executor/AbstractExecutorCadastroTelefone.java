package br.gov.incra.cadastrobeneficiarios.service.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.Telefone;
import br.gov.incra.cadastrobeneficiarios.model.repository.TelefoneRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

public abstract class AbstractExecutorCadastroTelefone implements AcaoCadastroBeneficiario {

    private final TelefoneRepository telefoneRepository;

    public AbstractExecutorCadastroTelefone(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    @Override
    public void executa(CadastroBeneficiarioForm form) {
        List<Telefone> novaListaTelefones = new ArrayList<>();
        form.getTelefones().forEach(telefone -> novaListaTelefones.add(new Telefone(telefone, form.getBeneficiario())));

        if(isFuncionalidadeAlteracaoTelefone()) {
            List<Telefone> listaTelefones = telefoneRepository.findByCpf(form.getBeneficiario().getCpf());
            List<Telefone> telefonesAlterados = listaTelefones.stream().filter(telefone -> !novaListaTelefones.contains(telefone))
                .collect(Collectors.toList());
            telefonesAlterados.forEach(telefone -> telefone.setAtivo(false));
            telefoneRepository.saveAll(telefonesAlterados);
        }
        telefoneRepository.saveAll(novaListaTelefones);
    }

    protected abstract boolean isFuncionalidadeAlteracaoTelefone();
}
