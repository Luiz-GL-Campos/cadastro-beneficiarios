package br.gov.incra.cadastrobeneficiarios.model.repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.incra.cadastrobeneficiarios.model.entity.TipoConta;

@SpringBootTest
public class TipoContaRepositoryTest {
    
    @Autowired
    private TipoContaRepository tipoContaRepository;

    @Test
    public void deveListarTiposConta(){
        List<TipoConta> listaTiposConta = tipoContaRepository.findAll();
        assertNotNull(listaTiposConta);
        assertFalse(listaTiposConta.isEmpty());
        assertEquals(3, listaTiposConta.size());
    }
}
