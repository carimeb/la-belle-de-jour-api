package com.labelledejour.api.domain.usecase.produto;

import com.labelledejour.api.domain.contract.ProdutoRepository;
import com.labelledejour.api.domain.entity.Produto;
import com.labelledejour.api.web.rest.ProdutoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;

@Service
public class AtualizarProduto {

    @Autowired
    ProdutoRepository produtoRepository;

    public void update(Produto produto, @Valid ProdutoRequest produtoRequest){
        produto.setNome(produtoRequest.getNome());
        produto.setFichaTecnica(produtoRequest.getFichaTecnica());
        produto.setAtualizadoEm(LocalDate.now());

        produtoRepository.update(produto);
    }
}
