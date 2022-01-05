package br.gov.incra.cadastrobeneficiarios.model.repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.incra.cadastrobeneficiarios.model.entity.Banco;

@SpringBootTest
public class BancoRepositoryTest {

    @Autowired
    private BancoRepository bancoRepository;

    @Test
    public void deveListarBancos(){
        List<Banco> listaBancos = bancoRepository.findAll();
        assertNotNull(listaBancos);
        assertFalse(listaBancos.isEmpty());
        assertEquals(13, listaBancos.size());
    }

}
