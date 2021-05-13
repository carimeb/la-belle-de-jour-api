package com.labelledejour.api.domain.usecase.produto;

import com.labelledejour.api.domain.contract.ProdutoRepository;
import com.labelledejour.api.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Listar {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> list(){
        return produtoRepository.list();
    }

    public Produto listById(long id) {
        return produtoRepository.listById(id);
    }
}
