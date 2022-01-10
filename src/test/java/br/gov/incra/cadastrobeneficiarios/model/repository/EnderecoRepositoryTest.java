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
import br.gov.incra.cadastrobeneficiarios.model.builder.EnderecoBuilder;
import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;
import br.gov.incra.cadastrobeneficiarios.model.entity.Endereco;
import br.gov.incra.cadastrobeneficiarios.model.entity.Municipio;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class EnderecoRepositoryTest {
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;
    @Autowired
    private MunicipioRepository municipioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    private Beneficiario beneficiario;
    private Municipio municipio;
    private Endereco endereco;

    @Test
    @Rollback(false)
    @Order(1)
    public void naoDeveCadastrarEndereco(){
        Endereco endereco = new EnderecoBuilder()
            .cep("70762500")
                .bairro("Asa Norte")
                .endereco("Asa Norte Comércio Local Norte 112")
                .enderecoAtivo(false)
                .numero("112")
                .cpfBeneficiario("0000012")
                .idMunicipio(municipio.getIdMunicipio())
            .Build();
            assertThrows(
            DataIntegrityViolationException.class, 
            () -> {
                enderecoRepository.save(endereco);
            }
        );

    }

    @Test
    @Rollback(false)
    @Order(2)
    public void deveCadastrarEndereco(){
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
        Municipio municipioSalvo = municipioRepository.save(municipio);
        assertNotNull(municipioSalvo);
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        assertNotNull(enderecoSalvo);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void deveAlterarEndereco(){
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
        Municipio municipioSalvo = municipioRepository.save(municipio);
        assertNotNull(municipioSalvo);
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        assertNotNull(enderecoSalvo);
        endereco.setCep("70833030");
        endereco.setBairro("Asa Sul");
        endereco.setEndereco("Asa Sul Comércio Residencial Sul 505");
        endereco.setEnderecoAtivo(true);
        endereco.setNumero("505");
        Endereco enderecoAlterado = enderecoRepository.save(endereco);
        assertNotNull(enderecoAlterado);
        assertEquals("70833030", enderecoAlterado.getCep());
        assertEquals("Asa Sul", enderecoAlterado.getBairro());
        assertEquals("Asa Sul Comércio Residencial Sul 505", enderecoAlterado.getEndereco());
        assertEquals(true, enderecoAlterado.getEnderecoAtivo());
        assertEquals("505", enderecoAlterado.getNumero());
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void deveExcluirEndereco(){
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
        enderecoRepository.save(endereco);
        Optional<Endereco> enderecoExcluido = enderecoRepository.findById(1L);
        assertFalse(enderecoExcluido.isPresent());
    }

    @Test
    @BeforeAll
    public void iniciar(){
        beneficiario = new BeneficiarioBuilder()
            .cpf("12345678901")
            .nome("Rogerinho")
            .dataNascimento(LocalDate.of(2000, 4, 13))
            .rg(0001123L)
            .orgaoEmissor("SSP/DF")
            .dataEmissao(LocalDate.of(2006, 9, 23))
            .idGenero(1L)
            .idEscolaridade(7L)
        .Build();
        municipio = new Municipio(5300108L, "Brasilia", 53L);
        endereco = new EnderecoBuilder()
            .cep("70304000")
            .bairro("Asa Sul")
            .endereco("Setor Comercial Sul Q. 4")
            .enderecoAtivo(true)
            .numero("4")
            .cpfBeneficiario(beneficiario.getCpfBeneficiario())
            .idMunicipio(municipio.getIdMunicipio())
        .Build();
    }

    @Test
    @AfterAll
    @Rollback(false)
    public void finalizar(){
        enderecoRepository.deleteAll();
        municipioRepository.deleteAll();
        beneficiarioRepository.deleteAll();
    }
}
