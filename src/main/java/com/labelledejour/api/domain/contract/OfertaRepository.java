package com.labelledejour.api.domain.contract;

import com.labelledejour.api.domain.entity.Oferta;

import java.util.List;

public interface OfertaRepository {

    void save(Oferta oferta);  //Create, de CRUD

    List<Oferta> list();

    Oferta listById(long id);
}
