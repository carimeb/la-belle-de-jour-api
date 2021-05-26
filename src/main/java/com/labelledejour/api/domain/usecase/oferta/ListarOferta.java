package com.labelledejour.api.domain.usecase.oferta;

import com.labelledejour.api.domain.contract.OfertaRepository;
import com.labelledejour.api.domain.entity.Oferta;
import com.labelledejour.api.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarOferta {

    @Autowired
    OfertaRepository ofertaRepository;

    public List<Oferta> list(){
        return ofertaRepository.list();
    }

    public Oferta listById(long id) {
        return ofertaRepository.listById(id);
    }
}
