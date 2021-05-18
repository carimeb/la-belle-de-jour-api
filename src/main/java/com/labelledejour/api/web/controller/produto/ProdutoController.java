package com.labelledejour.api.web.controller.produto;

import com.labelledejour.api.domain.entity.Produto;
import com.labelledejour.api.domain.usecase.produto.Atualizar;
import com.labelledejour.api.domain.usecase.produto.Cadastrar;
import com.labelledejour.api.domain.usecase.produto.Listar;
import com.labelledejour.api.domain.usecase.produto.Deletar;
import com.labelledejour.api.web.converter.ProdutoConverter;
import com.labelledejour.api.web.rest.ProdutoRequest;
import com.labelledejour.api.web.rest.ProdutoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    @Autowired
    ProdutoConverter produtoConverter;

    @Autowired
    Cadastrar cadastrar;

    @Autowired
    Listar listar;

    @Autowired
    Atualizar atualizar;

    @Autowired
    Deletar deletar;

    @PostMapping
    public void save(@RequestBody @Valid ProdutoRequest produtoRequest){
        Produto produto = produtoConverter.toProduto(produtoRequest);
        cadastrar.save(produto);
    }

    @GetMapping
    public List<ProdutoResponse> list() {
        List<Produto> produtos = listar.list();
        return produtoConverter.toProdutoResponse(produtos);
    }

    @GetMapping("/{id}")
    public ProdutoResponse product(@PathVariable long id) {
        Produto produto = listar.listById(id);
        return produtoConverter.toProdutoResponse(produto);
    }

    @PutMapping("/{id}")  //atualiza todos os campos, não só um ou outro
    public void update(@NotBlank @PathVariable long id, @RequestBody @Valid ProdutoRequest produtoRequest) {
        Produto produtoPersistido = listar.listById(id);
        atualizar.update(produtoPersistido, produtoRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        Produto produto = listar.listById(id);  //já ganhei a exceção aqui
        deletar.delete(produto);
    }
}
