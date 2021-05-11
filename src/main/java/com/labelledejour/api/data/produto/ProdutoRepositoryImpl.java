package com.labelledejour.api.data.produto;

import com.labelledejour.api.domain.contract.ProdutoRepository;
import com.labelledejour.api.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @Autowired
    ProdutoDao produtoDao;

    @Override
    public void save(Produto produto) {
        produtoDao.save(ProdutoEntity.of(produto));
    }

    @Override
    public List<Produto> list() {
        return produtoDao.findAll().stream()
                .map(ProdutoEntity::toProduto)
                .collect(Collectors.toList());
    }
}
