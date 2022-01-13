package br.gov.incra.cadastrobeneficiarios.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class BeneficiarioControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private static final String cadastro = 
        "{"
            +"\"beneficiario\":{" 
                + "\"cpf\":\"05847626182\","
                + "\"nome\":\"Madruguinha\","
                + "\"dataNascimento\":\"1988-02-02\","
                + "\"rg\":\"2151755\","
                + "\"orgaoEmissor\":\"SSP-DF\","
                + "\"dataEmissao\":\"2003-05-10\","
                + "\"idGenero\":\"1\","
                + "\"idEscolaridade\":\"5\""
            +"},"

            +"\"contas\":[{"
                + "\"agencia\":\"8256\","
                + "\"numeroConta\":\"859830\","
                + "\"idTipoConta\":\"2\","
                + "\"codBanco\":\"1\""
            +"},{"
                + "\"agencia\":\"9367\","
                + "\"numeroConta\":\"961094\","
                + "\"idTipoConta\":\"1\","
                + "\"codBanco\":\"104\""
            +"}],"

            +"\"emails\":[{"
                + "\"enderecoEmail\":\"madruguinha@gmail.com\""
            +"},{"
                + "\"enderecoEmail\":\"srcaloteiro@hotmail.com\""
            +"}],"

            +"\"enderecos\":[{"
                + "\"cep\":\"89632741\","
                + "\"bairro\":\"vila do chaves\","
                + "\"endereco\":\"qr 517 cj C casa\","
                + "\"enderecoAtivo\":\"true\","
                + "\"numero\":\"72\","
                + "\"municipioForm\":{"
                    + "\"idMunicipio\":\"1\","
                    + "\"nomeMunicipio\":\"Virabrequim Norte\","
                    + "\"idEstado\":\"31\""
                + "}"
            +"}],"

            + "\"telefones\":[{"
                + "\"numeroTelefone\":\"61973692463\","
                + "\"telefoneAtivo\":\"true\","
                + "\"idTipoTelefone\":\"2\""
            +"},{"
                + "\"numeroTelefone\":\"6130028022\","
                + "\"telefoneAtivo\":\"false\","
                + "\"idTipoTelefone\":\"1\""
            +"}]"
            
        +"}";

    @Test
    @Rollback(false)
    public void deveCadastrarBeneficiario() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .post("/beneficiario")
            .content(cadastro)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
