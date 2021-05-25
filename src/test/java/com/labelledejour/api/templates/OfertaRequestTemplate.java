package com.labelledejour.api.templates;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class OfertaRequestTemplate {

    private final String preco;

    private final String ofertante;

    private final String expiraEm;

    private final String redirectLink;

    private final String produtoId;

    public static OfertaRequestTemplateBuilder defaultBuilder() {
        return OfertaRequestTemplate.builder()
                .preco("10.99")
                .ofertante("Natura")
                .expiraEm(LocalDate.now().plusDays(2).toString())
                .redirectLink("https://www.natura.com.br/p/mascara-nutritiva-cabelos-cacheados-lumina-250ml/" +
                        "86959?list_title=Resultado%20de%20Busca&list_position=1")
                .produtoId("1");

    }
}
