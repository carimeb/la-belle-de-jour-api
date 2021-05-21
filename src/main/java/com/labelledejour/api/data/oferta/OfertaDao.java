package com.labelledejour.api.data.oferta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaDao extends JpaRepository<OfertaEntity, Long> {

}
