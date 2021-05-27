package com.labelledejour.api.domain.usecase.oferta;

import com.labelledejour.api.domain.contract.OfertaRepository;
import com.labelledejour.api.domain.entity.Oferta;
import com.labelledejour.api.domain.entity.Produto;
import com.labelledejour.api.web.rest.OfertaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class AtualizarOferta {

    @Autowired
    OfertaRepository ofertaRepository;

    public void update(Oferta oferta, @Valid OfertaRequest ofertaRequest) {

        Produto produto = new Produto();
        produto.setId(ofertaRequest.getProdutoId());

        oferta.setPreco(new BigDecimal(ofertaRequest.getPreco()));
        oferta.setOfertante(ofertaRequest.getOfertante());
        oferta.setExpiraEm(LocalDate.now().plusDays(2));
        oferta.setRedirectLink(ofertaRequest.getRedirectLink());
        oferta.setProduto(produto);

        ofertaRepository.update(oferta);
    }
}
