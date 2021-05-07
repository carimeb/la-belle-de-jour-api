package com.labelledejour.api.web.controller.produto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labelledejour.api.ApiApplication;
import com.labelledejour.api.web.rest.ProdutoRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ApiApplication.class
)
@AutoConfigureMockMvc
class ProdutoControllerTest {

    private static final String BASE_URL = "/api/v1/produto";
    @Autowired
    private MockMvc mvc;

    @Test
    void deveSalvarUmNovoProduto() throws Exception {

        var produtoRequest = ProdutoRequest.builder()
                .nome("batom teste")
                .fichaTecnica("ficha do batom teste")
                .build();

        var objectMapper = new ObjectMapper();
        var body = objectMapper.writeValueAsString(produtoRequest);

        mvc.perform(
                post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        ).andExpect(status().isOk());
    }

    @Test
    void deveValidarRequestDeUmNovoProduto() throws Exception {

        var produtoRequest = ProdutoRequest.builder()
                .nome("")
                .fichaTecnica("ficha do batom teste")
                .build();

        var objectMapper = new ObjectMapper();
        var body = objectMapper.writeValueAsString(produtoRequest);

        mvc.perform(
                post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        )
                .andExpect(status().is(400))
                .andExpect(jsonPath("[0].field", is("nome")))
                .andExpect(jsonPath("[0].message", is("Campo obrigatório")));
    }
}