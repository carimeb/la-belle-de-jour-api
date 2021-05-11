package com.labelledejour.api.domain.contract;

import com.labelledejour.api.domain.entity.Produto;

import java.util.List;


public interface ProdutoRepository {

    public void save(Produto produto);

    public List<Produto> list();
}
