package com.labelledejour.api.domain.usecase.oferta;

import com.labelledejour.api.domain.contract.OfertaRepository;
import com.labelledejour.api.domain.entity.Oferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarOferta {

    @Autowired
    private OfertaRepository ofertaRepository;

    public void save(Oferta oferta) {
        ofertaRepository.save(oferta);
    }
}
