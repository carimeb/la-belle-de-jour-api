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

    public List<ProdutoResponse> toProdutoResponse(List<Produto> produtos) {
        return produtos.stream()
               .map(produto -> ProdutoResponse.builder()
                        .id(produto.getId())
                        .nome(produto.getNome())
                        .fichaTecnica(produto.getFichaTecnica())
                        .build()).collect(Collectors.toList());
    }

    public ProdutoResponse toProdutoResponse(Produto produto) {
        return ProdutoResponse.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .fichaTecnica(produto.getFichaTecnica())
                .build();
    }
}
