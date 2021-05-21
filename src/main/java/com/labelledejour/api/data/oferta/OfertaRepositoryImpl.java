package com.labelledejour.api.data.oferta;

import com.labelledejour.api.domain.contract.OfertaRepository;
import com.labelledejour.api.domain.entity.Oferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OfertaRepositoryImpl implements OfertaRepository {

    @Autowired
    OfertaDao ofertaDao;

    @Override
    public void save(Oferta oferta) {
        ofertaDao.save(OfertaEntity.from(oferta));
    }
}
