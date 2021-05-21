package com.labelledejour.api.web.converter;

import com.labelledejour.api.domain.entity.Oferta;
import com.labelledejour.api.domain.entity.Produto;
import com.labelledejour.api.web.rest.OfertaRequest;
import org.springframework.stereotype.Component;

@Component
public class OfertaConverter {

    public Oferta toOferta(OfertaRequest ofertaRequest) {  //conversor da camada web para camada domain
        Produto produto = new Produto();
        produto.setId(ofertaRequest.getProdutoId());

        Oferta oferta = new Oferta();
        oferta.setPreco(ofertaRequest.getPreco());
        oferta.setOfertante(ofertaRequest.getOfertante());
        oferta.setExpiraEm(ofertaRequest.getExpiraEm());
        oferta.setRedirectLink(ofertaRequest.getRedirectLink());
        oferta.setProduto(produto);

        return oferta;
    }
}
