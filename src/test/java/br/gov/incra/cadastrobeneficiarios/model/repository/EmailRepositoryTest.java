package br.gov.incra.cadastrobeneficiarios.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;

import br.gov.incra.cadastrobeneficiarios.model.builder.BeneficiarioBuilder;
import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;
import br.gov.incra.cadastrobeneficiarios.model.entity.Email;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class EmailRepositoryTest {

    @Autowired
    private EmailRepository emailRepository;
    private Email email;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;
    private Beneficiario beneficiario;

    @Test
    @Rollback(false)
    @Order(1)
    public void nãoDeveCadastrarEmail(){
        Email email = new Email("luiz1gustavocampos@gmail.com", "11223345678");
        assertThrows(
            DataIntegrityViolationException.class, 
            () -> {
                emailRepository.save(email);
            }
        );
    }

    @Test
    @Rollback(false)
    @Order(2)
    public void deveCadastrarEmail(){
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
        email = new Email("luiz1gustavocampos@gmail.com", beneficiarioSalvo.getCpfBeneficiario());
        Email emailSalvo = emailRepository.save(email);
        assertNotNull(emailSalvo);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void deveAlterarEmail(){
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
        email = new Email("luiz1gustavocampos@gmail.com", beneficiario.getCpfBeneficiario());
        emailRepository.save(email);
        email.setEnderecoEmail("jorgin@gmail.com");
        Email emailAlteradoSalvo = emailRepository.save(email);
        assertNotNull(emailAlteradoSalvo);
        assertEquals("jorgin@gmail.com", email.getEnderecoEmail());
        System.out.println(email.getIdEmail());
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void deveExcluirEmail(){
        emailRepository.delete(email);
        Optional<Email> email = emailRepository.findById(25L);
        assertFalse(email.isPresent());
    }

    @BeforeAll
    public void iniciar(){
        beneficiario = new BeneficiarioBuilder()
            .cpf("04857636131")
            .nome("Luiz")
            .dataNascimento(LocalDate.of(1999, 12, 23))
            .rg(3121899L)
            .dataEmissao(LocalDate.of(2005, 6, 12))
            .idGenero(1L)
            .idEscolaridade(7L)
        .Build();
    }

    @AfterAll
    @Rollback(false)
    public void finalizarTeste(){
        emailRepository.deleteAll();
    }
    
}
