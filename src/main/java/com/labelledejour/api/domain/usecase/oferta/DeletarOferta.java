package com.labelledejour.api.domain.usecase.oferta;

import com.labelledejour.api.domain.contract.OfertaRepository;
import com.labelledejour.api.domain.entity.Oferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarOferta {

    @Autowired
    OfertaRepository ofertaRepository;

    public void delete(Oferta oferta){
        ofertaRepository.delete(oferta);
    }
}
