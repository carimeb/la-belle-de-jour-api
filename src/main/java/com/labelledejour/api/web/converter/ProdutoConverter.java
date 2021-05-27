package com.labelledejour.api.web.converter;

import com.labelledejour.api.domain.entity.Produto;
import com.labelledejour.api.web.rest.ProdutoRequest;
import com.labelledejour.api.web.rest.ProdutoResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoConverter {

    public Produto toProduto(ProdutoRequest produtoRequest){
        return new Produto(produtoRequest.getNome(), produtoRequest.getFichaTecnica());
    }

    //tranforma uma lista da entidade Produto do domain em uma lista de ProdutoResponse da camada web
    //(ou seja, a resposta à solicitação de determinado endpoint)
    public List<ProdutoResponse> toProdutoResponse(List<Produto> produtos) {
                return produtos.stream()
               .map(produto -> ProdutoResponse.builder()
                        .id(produto.getId())
                        .nome(produto.getNome())
                        .fichaTecnica(produto.getFichaTecnica())
                        .atualizadoEm(produto.getAtualizadoEm())
                        .build()).collect(Collectors.toList());
    }

    //tranforma uma entidade Produto do domain em ProdutoResponse da camada web
    //(ou seja, a resposta à solicitação de determinado endpoint)
    public ProdutoResponse toProdutoResponse(Produto produto) {
        return ProdutoResponse.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .fichaTecnica(produto.getFichaTecnica())
                .atualizadoEm(produto.getAtualizadoEm())
                .build();
    }
}
