package br.gov.incra.cadastrobeneficiarios.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.gov.incra.cadastrobeneficiarios.model.builder.BeneficiarioBuilder;
import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class BeneficiarioRepositoryTest {
    
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;
    private Beneficiario beneficiario;

    @Test
    @Rollback(false)
    @Order(1)
    public void deveCadastrarBeneficiario(){
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
    }

    @Test
    @Rollback(false)
    @Order(2)
    public void deveAlterarBeneficiario(){
        beneficiario.setNomeBeneficiario("Flavinho");
        beneficiario.setDataNascimentoBeneficiario(LocalDate.of(1998, 6, 2));
        beneficiario.setIdEscolaridade(6L);
        Beneficiario beneficiarioAlteradoSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioAlteradoSalvo);
        assertEquals("Flavinho", beneficiarioAlteradoSalvo.getNomeBeneficiario());
        assertEquals(LocalDate.of(1998, 6, 2), beneficiarioAlteradoSalvo.getDataNascimentoBeneficiario());
        assertEquals(6L, beneficiarioAlteradoSalvo.getIdEscolaridade());
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void deveExcluirBeneficiario(){
        beneficiarioRepository.delete(beneficiario);
        Optional<Beneficiario> beneficiario = beneficiarioRepository.findById("04857636131");
        assertFalse(beneficiario.isPresent());

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
        beneficiarioRepository.deleteAll();
    }

}
