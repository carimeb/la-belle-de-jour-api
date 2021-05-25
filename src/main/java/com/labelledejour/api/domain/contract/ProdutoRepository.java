package com.labelledejour.api.domain.contract;

import com.labelledejour.api.domain.entity.Produto;

import java.util.List;


public interface ProdutoRepository {

    void save(Produto produto);  //Create, de CRUD

    List<Produto> list();  //Retrieve, de CRUD

    Produto listById(long id);  //Retrieve, de CRUD

    void update(Produto produto);  //Update, de CRUD

    void delete(Produto produto);  //Delete, de CRUD
}
