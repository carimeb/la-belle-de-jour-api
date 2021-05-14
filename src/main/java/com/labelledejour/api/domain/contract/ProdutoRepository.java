package com.labelledejour.api.domain.contract;

import com.labelledejour.api.domain.entity.Produto;

import java.util.List;


public interface ProdutoRepository {

    void save(Produto produto);

    List<Produto> list();

    Produto listById(long id);

    void update(Produto produto);
}
