package br.gov.incra.cadastrobeneficiarios.model.repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.incra.cadastrobeneficiarios.model.entity.Escolaridade;


@SpringBootTest
public class EscolaridadeRepositoryTest {

    @Autowired
    private EscolaridadeRepository escolaridadeRepository;

    @Test
    public void deveListarEscolaridades(){
        List<Escolaridade> listaEscolaridades = escolaridadeRepository.findAll();
        assertNotNull(listaEscolaridades);
        assertFalse(listaEscolaridades.isEmpty());
        assertEquals(11, listaEscolaridades.size());
    }
}
