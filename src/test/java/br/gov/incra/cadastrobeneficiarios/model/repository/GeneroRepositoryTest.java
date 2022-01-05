package br.gov.incra.cadastrobeneficiarios.model.repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.incra.cadastrobeneficiarios.model.entity.Genero;

@SpringBootTest
public class GeneroRepositoryTest {
    
    @Autowired
    private GeneroRepository generoRepository;

    @Test
    public void deveListarGeneros(){
        List<Genero> listaGeneros = generoRepository.findAll();
        assertNotNull(listaGeneros);
        assertFalse(listaGeneros.isEmpty());
        assertEquals(2, listaGeneros.size());
    }
}
