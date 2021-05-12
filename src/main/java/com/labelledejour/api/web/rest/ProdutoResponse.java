package com.labelledejour.api.web.rest;

import lombok.Builder;

@Builder
public class ProdutoResponse {

    public long id;
    public String nome;
    public String fichaTecnica;
}
