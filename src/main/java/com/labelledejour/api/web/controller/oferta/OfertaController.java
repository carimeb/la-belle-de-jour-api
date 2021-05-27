package com.labelledejour.api.web.controller.oferta;

import com.labelledejour.api.domain.entity.Oferta;
import com.labelledejour.api.domain.usecase.oferta.AtualizarOferta;
import com.labelledejour.api.domain.usecase.oferta.CadastrarOferta;
import com.labelledejour.api.domain.usecase.oferta.ListarOferta;
import com.labelledejour.api.web.converter.OfertaConverter;
import com.labelledejour.api.web.rest.OfertaRequest;
import com.labelledejour.api.web.rest.OfertaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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

    @Autowired
    AtualizarOferta atualizarOferta;

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

    @PutMapping("/{id}")
    public void update(@NotBlank @PathVariable long id, @RequestBody @Valid OfertaRequest ofertaRequest) {
        Oferta ofertaPersistida = listarOferta.listById(id);
        atualizarOferta.update(ofertaPersistida, ofertaRequest);
    }

}
