package br.gov.incra.cadastrobeneficiarios.model.repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.incra.cadastrobeneficiarios.model.entity.TipoTelefone;

@SpringBootTest
public class TipoTelefoneRepositoryTest {
    
    @Autowired
    private TipoTelefoneRepository tipoTelefoneRepository;

    @Test
    public void deveListarTiposTelefone(){
        List<TipoTelefone> listaTiposTelefone = tipoTelefoneRepository.findAll();
        assertNotNull(listaTiposTelefone);
        assertFalse(listaTiposTelefone.isEmpty());
        assertEquals(3, listaTiposTelefone.size());
    }
}
