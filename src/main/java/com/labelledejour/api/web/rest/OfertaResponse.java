package com.labelledejour.api.web.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfertaResponse {

    public final long id;
    public final BigDecimal preco;
    public final String ofertante;
    public final LocalDate expiraEm;
    public final String redirectLink;
    public final ProdutoResponse produtoResponse;
}
