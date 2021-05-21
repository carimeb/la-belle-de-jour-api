package com.labelledejour.api.web.controller.oferta;

import com.labelledejour.api.domain.entity.Oferta;
import com.labelledejour.api.domain.usecase.oferta.CadastrarOferta;
import com.labelledejour.api.web.converter.OfertaConverter;
import com.labelledejour.api.web.rest.OfertaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/oferta")
public class OfertaController {

    @Autowired
    OfertaConverter ofertaConverter;

    @Autowired
    CadastrarOferta cadastrar;

    @PostMapping
    public void save(@RequestBody @Valid OfertaRequest ofertaRequest) {
        Oferta oferta = ofertaConverter.toOferta(ofertaRequest);  //conversor de request para domain
        cadastrar.save(oferta);
    }
}
