package com.labelledejour.api.web.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDate;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoResponse {

    public long id;
    public String nome;
    public String fichaTecnica;
    public LocalDate atualizadoEm;
}
