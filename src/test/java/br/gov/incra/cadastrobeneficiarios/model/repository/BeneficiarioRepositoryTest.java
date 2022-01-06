package br.gov.incra.cadastrobeneficiarios.model.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.gov.incra.cadastrobeneficiarios.model.builder.BeneficiarioBuilder;
import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;

@SpringBootTest
public class BeneficiarioRepositoryTest {
    
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Test
    @Rollback(false)
    public void deveCadastrarBeneficiario(){
        Beneficiario beneficiario = new BeneficiarioBuilder()
            .cpf("04857636131")
            .nome("Luiz")
            .dataNascimento(LocalDate.of(1999, 12, 23))
            .rg(3121899L)
            .dataEmissao(LocalDate.of(2005, 6, 12))
            .idGenero(1L)
            .idEscolaridade(7L)
        .Build();
        Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
        assertNotNull(beneficiarioSalvo);
    }

    @AfterEach
    @Rollback(false)
    public void finalizarTeste(){
        beneficiarioRepository.deleteAll();
    }

}
