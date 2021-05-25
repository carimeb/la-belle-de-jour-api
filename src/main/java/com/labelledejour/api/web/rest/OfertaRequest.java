package com.labelledejour.api.web.rest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class OfertaRequest {  //representa o que vem de fora pra dentro

    @NotNull(message = "Campo obrigatório")
    private String preco;

    @NotBlank(message = "Campo obrigatório")
    private String ofertante;

    @NotNull(message = "Campo obrigatório")
    @FutureOrPresent(message = "Data não pode ser no passado")
    private LocalDate expiraEm;

    @NotBlank(message = "Campo obrigatório")
    @Length(max = 300, message = "Máx.: 300 caracteres")
    private String redirectLink;

    @NotNull(message = "Campo obrigatório")
    private Long produtoId;

}
