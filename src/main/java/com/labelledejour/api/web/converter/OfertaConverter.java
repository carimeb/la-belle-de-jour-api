package com.labelledejour.api.web.converter;

import com.labelledejour.api.domain.entity.Oferta;
import com.labelledejour.api.domain.entity.Produto;
import com.labelledejour.api.web.rest.OfertaRequest;
import com.labelledejour.api.web.rest.OfertaResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OfertaConverter {

    public Oferta toOferta(OfertaRequest ofertaRequest) {  //conversor da camada web para camada domain
        Produto produto = new Produto();
        produto.setId(ofertaRequest.getProdutoId());

        Oferta oferta = new Oferta();
        oferta.setPreco(new BigDecimal(ofertaRequest.getPreco()));
        oferta.setOfertante(ofertaRequest.getOfertante());
        oferta.setExpiraEm(ofertaRequest.getExpiraEm());
        oferta.setRedirectLink(ofertaRequest.getRedirectLink());
        oferta.setProduto(produto);

        return oferta;
    }

    public List<OfertaResponse> toOfertaResponse(List<Oferta> ofertas) {
        ProdutoConverter produtoConverter = new ProdutoConverter();

        return ofertas.stream()
                .map(oferta -> OfertaResponse.builder()
                        .id(oferta.getId())
                        .preco(oferta.getPreco())
                        .ofertante(oferta.getOfertante())
                        .expiraEm(oferta.getExpiraEm())
                        .redirectLink(oferta.getRedirectLink())
                        .produtoResponse(produtoConverter.toProdutoResponse(oferta.getProduto()))
                        .build()
                ).collect(Collectors.toList());
    }

    public OfertaResponse toOfertaResponse(Oferta oferta) {
        ProdutoConverter produtoConverter = new ProdutoConverter();

        return OfertaResponse.builder()
                .id(oferta.getId())
                .preco(oferta.getPreco())
                .ofertante(oferta.getOfertante())
                .expiraEm(oferta.getExpiraEm())
                .redirectLink(oferta.getRedirectLink())
                .produtoResponse(produtoConverter.toProdutoResponse(oferta.getProduto()))
                .build();
    }
}
