package com.labelledejour.api.web.controller.produto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labelledejour.api.ApiApplication;
import com.labelledejour.api.domain.contract.ProdutoRepository;
import com.labelledejour.api.domain.entity.Produto;
import com.labelledejour.api.web.rest.ProdutoRequest;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(    //configura ambiente de teste
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ApiApplication.class
)
@AutoConfigureMockMvc
class ProdutoControllerTest {

    private static final String BASE_URL = "/api/v1/produto";
    private static final String TRUNCATE = "classpath:db/sql/reset.sql";
    private static final String LISTA_PRODUTOS = "classpath:db/sql/produto/inserir_lista_de_produtos.sql";

    @Autowired
    private MockMvc mvc;  //faz requisições (mockadas) pro endpoint

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    void deveSalvarUmNovoProduto() throws Exception {

        var produtoRequest = ProdutoRequest.builder()
                .nome("batom teste")
                .fichaTecnica("ficha técnica do batom teste. Produto muito bom")
                .build();

        var objectMapper = new ObjectMapper();
        var body = objectMapper.writeValueAsString(produtoRequest);  //transforma um objeto Json em String

        mvc.perform(
                post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        ).andExpect(status().isOk());
    }

    @Test
    @Sql({TRUNCATE, LISTA_PRODUTOS})
    void deveAtualizarUmProdutoPorId() throws Exception {

        var produtoRequest = ProdutoRequest.builder()
                .nome("atualização do batom teste")
                .fichaTecnica("atualização da ficha técnica do batom teste. Produto muito bom")
                .build();

        var objectMapper = new ObjectMapper();
        var body = objectMapper.writeValueAsString(produtoRequest);  //transforma um objeto Json em String

        mvc.perform(
                put(BASE_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        ).andExpect(status().isOk());

        Produto produto = produtoRepository.listById(1L);
        /* Assertions.assertEquals("atualização do batom teste", produto.getNome());
        Assertions.assertEquals("atualização da ficha técnica do batom teste. Produto muito bom",
                produto.getFichaTecnica());
        */

        assertThat(produto.getNome(), is("atualização do batom teste"));
        assertThat(produto.getFichaTecnica(), is("atualização da ficha técnica do batom teste. Produto muito bom"));
    }

    @Test
    void deveValidarCampoNuloNaRequestDeUmNovoProduto() throws Exception {

        var produtoRequest = ProdutoRequest.builder()
                .nome("")
                .fichaTecnica("ficha técnica do batom teste. Produto muito bom")
                .build();

        var objectMapper = new ObjectMapper();
        var body = objectMapper.writeValueAsString(produtoRequest);System.out.println("Produto repository consultado");

        mvc.perform(
                post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        )
                .andExpect(status().is(400))
                .andExpect(jsonPath("[0].field", is("nome")))
                .andExpect(jsonPath("[0].message", is("Campo obrigatório")));
    }

    @Test
    void deveValidarValorMinimoNaFichaTecnicaNaRequestDeUmNovoProduto() throws Exception {

        var produtoRequest = ProdutoRequest.builder()
                .nome("batom teste")
                .fichaTecnica("ficha técnica do batom teste.")
                .build();

        var objectMapper = new ObjectMapper();
        var body = objectMapper.writeValueAsString(produtoRequest);

        mvc.perform(
                post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        )
                .andExpect(status().is(400))
                .andExpect(jsonPath("[0].field", is("fichaTecnica")))
                .andExpect(jsonPath("[0].message", is("Mín.: 30 e Máx.: 300 caracteres")));
    }

    @Test
    @Sql({TRUNCATE, LISTA_PRODUTOS})
    void deveListarTodosOsProdutos() throws Exception {

        mvc.perform(
                get(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void deveRetornarMsgAmigavelQdoProdutoNaoEncontrado() throws Exception {

        mvc.perform(
                get(BASE_URL + "/6")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("message", is("Produto não encontrado.")));
    }

    @Test
    @Sql({TRUNCATE, LISTA_PRODUTOS})
    void deveDeletarUmProduto() throws Exception {

        mvc.perform(
                delete(BASE_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());

        List<Produto> produtos = produtoRepository.list();
        assertThat(produtos.size(), is(1));  //certifica que sobrou apenas um produto na base de dados
    }
}