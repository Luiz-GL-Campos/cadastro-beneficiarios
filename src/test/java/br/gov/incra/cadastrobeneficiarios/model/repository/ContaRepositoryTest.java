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
import br.gov.incra.cadastrobeneficiarios.model.builder.ContaBuilder;
import br.gov.incra.cadastrobeneficiarios.model.entity.Banco;
import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;
import br.gov.incra.cadastrobeneficiarios.model.entity.Conta;
import br.gov.incra.cadastrobeneficiarios.model.entity.TipoConta;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class ContaRepositoryTest {
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;
    @Autowired
    private BancoRepository bancoRepository;
    @Autowired
    private TipoContaRepository tipoContaRepository;

    private Beneficiario beneficiario;
    private TipoConta tipoConta;
    private Banco banco;
    private Conta conta;

    @Test
    @Rollback(false)
    @Order(1)
    public void naoDeveCadastrarConta() {
        conta = new ContaBuilder()
            .agencia("1234")
            .numeroConta("1234321")
            .idTipoConta(tipoConta.getIdTipoConta())
            .codBanco(banco.getCodBanco())
            .cpfBeneficiario(beneficiario.getCpfBeneficiario())
        .Build();
        assertThrows(
            DataIntegrityViolationException.class, 
            () -> {
                contaRepository.save(conta);
            }
        );
    }

    @Test
    @Rollback(false)
    @Order(2)
    public void deveCadastrarConta() {
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
        TipoConta tipoContaSalva = tipoContaRepository.save(tipoConta);
        assertNotNull(tipoContaSalva);
        Banco bancoSalvo = bancoRepository.save(banco);
        assertNotNull(bancoSalvo);
        Conta contaSalva = contaRepository.save(conta);
        assertNotNull(contaSalva);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void deveAlterarConta() {
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
        TipoConta tipoContaSalva = tipoContaRepository.save(tipoConta);
        assertNotNull(tipoContaSalva);
        Banco bancoSalvo = bancoRepository.save(banco);
        assertNotNull(bancoSalvo);
        Conta contaSalva = contaRepository.save(conta);
        assertNotNull(contaSalva);
        conta.setAgencia("4321");
        conta.setNumeroConta("7654321");
        Conta contaAlterada = contaRepository.save(conta);
        assertNotNull(contaAlterada);
        assertEquals("4321", contaAlterada.getAgencia());
        assertEquals("7654321", contaAlterada.getNumeroConta());
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void deveExcluirConta(){
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
        contaRepository.save(conta);
        Optional<Conta> contaExcluida = contaRepository.findById(1L);
        assertFalse(contaExcluida.isPresent());
    }

    @Test
    @BeforeAll
    public void iniciar(){
        beneficiario = new BeneficiarioBuilder()
            .cpf("12345678901")
            .nome("Rogerinho")
            .dataNascimento(LocalDate.of(2000, 4, 13))
            .rg(1234567L)
            .orgaoEmissor("SSP/DF")
            .dataEmissao(LocalDate.of(2006, 9, 23))
            .idGenero(1L)
            .idEscolaridade(7L)
        .Build();
        tipoConta = new TipoConta(2L, "Corrente");
        banco = new Banco(341L, "Banco Itaú S.A.");
        conta = new ContaBuilder()
            .agencia("1234")
            .numeroConta("1234567")
            .idTipoConta(tipoConta.getIdTipoConta())
            .codBanco(banco.getCodBanco())
            .cpfBeneficiario(beneficiario.getCpfBeneficiario())
        .Build();
    }

    @Test
    @AfterAll
    @Rollback(false)
    public void finalizar(){
        contaRepository.deleteAll();
        beneficiarioRepository.deleteAll();
    }
}
