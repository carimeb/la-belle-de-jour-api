package com.labelledejour.api.domain.contract;

import com.labelledejour.api.domain.entity.Produto;


public interface ProdutoRepository {

    public void save(Produto produto);
}
