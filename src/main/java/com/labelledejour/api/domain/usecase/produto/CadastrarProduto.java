package com.labelledejour.api.domain.usecase.produto;

import com.labelledejour.api.domain.contract.ProdutoRepository;
import com.labelledejour.api.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarProduto {

    @Autowired
    ProdutoRepository produtoRepository;

    public void save(Produto produto){
        produtoRepository.save(produto);
    }
}
