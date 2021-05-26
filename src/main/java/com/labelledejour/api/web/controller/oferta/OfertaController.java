package com.labelledejour.api.web.controller.oferta;

import com.labelledejour.api.domain.entity.Oferta;
import com.labelledejour.api.domain.entity.Produto;
import com.labelledejour.api.domain.usecase.oferta.CadastrarOferta;
import com.labelledejour.api.domain.usecase.oferta.ListarOferta;
import com.labelledejour.api.web.converter.OfertaConverter;
import com.labelledejour.api.web.rest.OfertaRequest;
import com.labelledejour.api.web.rest.OfertaResponse;
import com.labelledejour.api.web.rest.ProdutoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/oferta")
public class OfertaController {

    @Autowired
    OfertaConverter ofertaConverter;

    @Autowired
    CadastrarOferta cadastrar;

    @Autowired
    ListarOferta listarOferta;

    @PostMapping
    public void save(@RequestBody @Valid OfertaRequest ofertaRequest) {
        Oferta oferta = ofertaConverter.toOferta(ofertaRequest);  //conversor de request para domain
        cadastrar.save(oferta);
    }

    @GetMapping
    public List<OfertaResponse> list() {
        List<Oferta> ofertas = listarOferta.list();
        return ofertaConverter.toOfertaResponse(ofertas);
    }

    @GetMapping("/{id}")
    public OfertaResponse product(@PathVariable long id) {
        Oferta oferta = listarOferta.listById(id);
        return ofertaConverter.toOfertaResponse(oferta);
    }

}
