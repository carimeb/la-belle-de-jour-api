package com.labelledejour.api.web.controller.oferta;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labelledejour.api.ApiApplication;
import com.labelledejour.api.domain.contract.OfertaRepository;
import com.labelledejour.api.domain.contract.ProdutoRepository;
import com.labelledejour.api.domain.entity.Produto;
import com.labelledejour.api.templates.OfertaRequestTemplate;
import com.labelledejour.api.web.rest.OfertaRequest;
import com.labelledejour.api.web.rest.ProdutoRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(    //configura ambiente de teste
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ApiApplication.class
)
@AutoConfigureMockMvc
class OfertaControllerTest {

    private static final String BASE_URL = "/api/v1/oferta";
    private static final String TRUNCATE = "classpath:db/sql/reset.sql";
    private static final String LISTA_PRODUTOS = "classpath:db/sql/produto/inserir_lista_de_produtos.sql";
    private static final String LISTA_OFERTAS = "classpath:db/sql/oferta/inserir_lista_de_ofertas.sql";

    @Autowired
    private MockMvc mvc;  //faz requisições (mockadas) pro endpoint

    @Autowired
    private OfertaRepository ofertaRepository;

    @Test
    @Sql({TRUNCATE, LISTA_PRODUTOS})
    void deveSalvarUmaNovaOferta() throws Exception {

        var ofertaRequest = OfertaRequestTemplate.defaultBuilder().build();

        var objectMapper = new ObjectMapper();
        var body = objectMapper.writeValueAsString(ofertaRequest);  //transforma um objeto Json em String

        mvc.perform(
                post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        ).andExpect(status().isOk());
    }

    @Test
    @Sql({TRUNCATE, LISTA_PRODUTOS, LISTA_OFERTAS})
    void deveListarTodasAsOfertas() throws Exception {

        mvc.perform(
                get(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

}