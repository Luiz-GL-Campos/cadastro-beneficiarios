package br.gov.incra.cadastrobeneficiarios.model.repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.incra.cadastrobeneficiarios.model.entity.Estado;

@SpringBootTest
public class EstadoRepositoryTest {
    
    @Autowired
    private EstadoRepository estadoRepository;

    @Test
    public void deveListarEstados(){
        List<Estado> listaEstados = estadoRepository.findAll();
        assertNotNull(listaEstados);
        assertFalse(listaEstados.isEmpty());
        assertEquals(27, listaEstados.size());
    }
}
