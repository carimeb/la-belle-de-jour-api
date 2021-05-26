package com.labelledejour.api.data.oferta;

import com.labelledejour.api.domain.contract.OfertaRepository;
import com.labelledejour.api.domain.entity.Oferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OfertaRepositoryImpl implements OfertaRepository {

    @Autowired
    OfertaDao ofertaDao;

    @Override
    public void save(Oferta oferta) {
        ofertaDao.save(OfertaEntity.from(oferta));
    }

    @Override
    public List<Oferta> list() {
        return ofertaDao.findAll().stream()
                .map(OfertaEntity::toOferta)
                .collect(Collectors.toList());
    }

    @Override
    public Oferta listById(long id) {
        OfertaEntity ofertaEntity = ofertaDao.findById(id)
                .orElseThrow(OfertaNaoEncontradaException::new);
        return ofertaEntity.toOferta();
    }
}
