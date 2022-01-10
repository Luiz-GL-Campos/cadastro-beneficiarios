package br.gov.incra.cadastrobeneficiarios.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;

import br.gov.incra.cadastrobeneficiarios.model.builder.BeneficiarioBuilder;
import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;
import br.gov.incra.cadastrobeneficiarios.model.entity.SituacaoBeneficiario;
import br.gov.incra.cadastrobeneficiarios.model.entity.SituacaoBeneficiarioId;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class SituacaoBeneficiarioRepositoryTest {
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;
    @Autowired
    private SituacaoBeneficiarioRepository situacaoBeneficiarioRepository;

    private Beneficiario beneficiario;

    @Test
    @Rollback(false)
    @Order(1)
    public void naoDeveCadastrarSituacaoBeneficiario() {
        SituacaoBeneficiario situacaoBeneficiario = new SituacaoBeneficiario(new SituacaoBeneficiarioId("12345678900", 2L) ,LocalDate.of(2011, 9, 24));
        assertThrows(
            DataIntegrityViolationException.class, 
            () -> {
                situacaoBeneficiarioRepository.save(situacaoBeneficiario);
            }
        );
    }

    @Test
    @Rollback(false)
    @Order(2)
    public void deveCadastrarSituacaoBeneficiario(){
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
        SituacaoBeneficiario situacaoBeneficiario = new SituacaoBeneficiario(new SituacaoBeneficiarioId(beneficiario.getCpfBeneficiario(), 2L), LocalDate.of(2010, 9, 24));
        SituacaoBeneficiario situacaoBeneficiarioSalva = situacaoBeneficiarioRepository.save(situacaoBeneficiario);
        assertNotNull(situacaoBeneficiarioSalva);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void deveAlterarSituacaoBeneficiario(){
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
        SituacaoBeneficiario situacaoBeneficiario = new SituacaoBeneficiario(new SituacaoBeneficiarioId(beneficiario.getCpfBeneficiario(), 2L), LocalDate.of(2010, 9, 24));
        situacaoBeneficiarioRepository.save(situacaoBeneficiario);
        situacaoBeneficiario.setDataAtualizacao(LocalDate.of(2012, 10, 25));
        SituacaoBeneficiario situacaoBeneficiarioAlteradaSalva = situacaoBeneficiarioRepository.save(situacaoBeneficiario);
        assertNotNull(situacaoBeneficiarioAlteradaSalva);
        assertEquals(LocalDate.of(2012, 10, 25), situacaoBeneficiarioAlteradaSalva.getDataAtualizacao());
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void deveExcluirSituacaoBeneficiario(){
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
        SituacaoBeneficiario situacaoBeneficiario = new SituacaoBeneficiario(new SituacaoBeneficiarioId(beneficiario.getCpfBeneficiario(), 2L), LocalDate.of(2010, 9, 24));
        situacaoBeneficiarioRepository.save(situacaoBeneficiario);
        situacaoBeneficiarioRepository.delete(situacaoBeneficiario);
        Optional<SituacaoBeneficiario> situacaoBeneficiarioExcluida = situacaoBeneficiarioRepository.findById(situacaoBeneficiario.getSituacaoBeneficiarioId());
        assertFalse(situacaoBeneficiarioExcluida.isPresent());
    }

    @Test
    @BeforeAll
    public void iniciar() {
        beneficiario = new BeneficiarioBuilder()
            .cpf("13251022881")
            .nome("Cleiton")
            .dataNascimento(LocalDate.of(1987, 10, 22))
            .rg(9876543L)
            .orgaoEmissor("SSP/DF")
            .dataEmissao(LocalDate.of(2005, 5, 12))
            .idGenero(1L)
            .idEscolaridade(8L)
        .Build();
    }

    @Test
    @AfterAll
    @Rollback(false)
    public void finalizar(){
        situacaoBeneficiarioRepository.deleteAll();
        beneficiarioRepository.deleteAll();
    }
}
