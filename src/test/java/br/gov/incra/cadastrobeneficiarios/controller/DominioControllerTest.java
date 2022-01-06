package br.gov.incra.cadastrobeneficiarios.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.platform.commons.util.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class DominioControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveRetornarStatusOkParaListaDeBancos() throws Exception {
        MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders.get("/dominio/listar-banco"))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertTrue(StringUtils.isNotBlank(resultado.getResponse().getContentAsString()));
    }

    @Test
    public void deveRetornarStatusOkParaListaDeEscolaridade() throws Exception {
            MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders.get("/dominio/listar-escolaridade"))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertTrue(StringUtils.isNotBlank(resultado.getResponse().getContentAsString()));
    }

    @Test
    public void deveRetornarStatusOkParaListaDeEstado() throws Exception {
            MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders.get("/dominio/listar-estado"))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertTrue(StringUtils.isNotBlank(resultado.getResponse().getContentAsString()));
    }

    @Test
    public void deveRetornarStatusOkParaListaDeGenero() throws Exception {
            MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders.get("/dominio/listar-genero"))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertTrue(StringUtils.isNotBlank(resultado.getResponse().getContentAsString()));
    }

    @Test
    public void deveRetornarStatusOkParaListaDeSituacao() throws Exception {
            MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders.get("/dominio/listar-situacao"))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertTrue(StringUtils.isNotBlank(resultado.getResponse().getContentAsString()));
    }

    @Test
    public void deveRetornarStatusOkParaListaDeTipoConta() throws Exception {
            MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders.get("/dominio/listar-tipo-conta"))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertTrue(StringUtils.isNotBlank(resultado.getResponse().getContentAsString()));
    }

    @Test
    public void deveRetornarStatusOkParaListaDeTipoTelefone() throws Exception {
            MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders.get("/dominio/listar-tipo-telefone"))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertTrue(StringUtils.isNotBlank(resultado.getResponse().getContentAsString()));
    }
}
