package com.labelledejour.api.domain.usecase.produto;

import com.labelledejour.api.domain.contract.ProdutoRepository;
import com.labelledejour.api.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Atualizar {

    @Autowired
    ProdutoRepository produtoRepository;

    public void update(Produto produto){
        produtoRepository.update(produto);
    }
}
