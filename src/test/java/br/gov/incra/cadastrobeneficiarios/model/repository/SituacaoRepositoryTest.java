package br.gov.incra.cadastrobeneficiarios.model.repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.incra.cadastrobeneficiarios.model.entity.Situacao;

@SpringBootTest
public class SituacaoRepositoryTest {
    
    @Autowired
    private SituacaoRepository situacaoRepository;

    @Test
    public void deveListarSituacoes(){
        List<Situacao> listaSituacoes = situacaoRepository.findAll();
        assertNotNull(listaSituacoes);
        assertFalse(listaSituacoes.isEmpty());
        assertEquals(4, listaSituacoes.size());
    }
}
