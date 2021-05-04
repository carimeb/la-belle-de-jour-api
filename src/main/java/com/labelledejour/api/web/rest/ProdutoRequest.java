package com.labelledejour.api.web.rest;

import javax.validation.constraints.NotNull;

public class ProdutoRequest {

    @NotNull(message = "Campo obrigatório")
    private String nome;
    @NotNull(message = "Campo obrigatório")
    private String fichaTecnica;

}
