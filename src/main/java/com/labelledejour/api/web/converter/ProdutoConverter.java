package com.labelledejour.api.web.converter;

import com.labelledejour.api.domain.entity.Produto;
import com.labelledejour.api.web.rest.ProdutoRequest;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConverter {

    public Produto toProduto(ProdutoRequest produtoRequest){
        return new Produto(produtoRequest.getNome(), produtoRequest.getFichaTecnica());
    }
}
