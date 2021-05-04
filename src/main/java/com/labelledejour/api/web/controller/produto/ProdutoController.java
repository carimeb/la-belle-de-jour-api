package com.labelledejour.api.web.controller.produto;

import com.labelledejour.api.web.rest.ProdutoRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    @PostMapping
    public void save(@RequestBody @Valid ProdutoRequest produtoRequest){
    }
}
