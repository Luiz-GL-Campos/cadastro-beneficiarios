package br.gov.incra.cadastrobeneficiarios.service.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.Email;
import br.gov.incra.cadastrobeneficiarios.model.repository.EmailRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

public abstract class AbstractExecutorCadastroEmail implements AcaoCadastroBeneficiario {
    private final EmailRepository emailRepository;

    public AbstractExecutorCadastroEmail(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public void executa(CadastroBeneficiarioForm form) {
        List<Email> novaListaEmails = new ArrayList<>();
        form.getEmails().forEach(email -> novaListaEmails.add(new Email(email, form.getBeneficiario())));

        if (isFuncionalidadeAlteracaoEmail()) {
            List<Email> listaEmails = emailRepository.findByCpf(form.getBeneficiario().getCpf());
            List<Email> diferenca = listaEmails.stream().filter(email -> !novaListaEmails.contains(email))
                    .collect(Collectors.toList());
            emailRepository.deleteAll(diferenca);
        }

        emailRepository.saveAll(novaListaEmails);
    }

    protected abstract boolean isFuncionalidadeAlteracaoEmail();
    
}
