package br.gov.incra.cadastrobeneficiarios.service.executor.cadastro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.form.EmailForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.Email;
import br.gov.incra.cadastrobeneficiarios.model.repository.EmailRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

@Service
public class ExecutorCadastroEmail implements AcaoCadastroBeneficiario {

    private final EmailRepository emailRepository;
    
    public ExecutorCadastroEmail(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public void executa(CadastroBeneficiarioForm form) {
        List<Email> listaEmail = new ArrayList<>();
        for (EmailForm email : form.getEmails()) {
            listaEmail.add(new Email(email, form.getBeneficiario()));
        }
        emailRepository.saveAll(listaEmail);
    }
    
}
