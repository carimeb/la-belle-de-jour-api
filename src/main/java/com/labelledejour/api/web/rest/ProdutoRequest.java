package com.labelledejour.api.web.rest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class ProdutoRequest {

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotBlank(message = "Campo obrigatório")
    @Length(min = 30, max = 300, message = "Mín.: 30 e Máx.: 300 caracteres")
    private String fichaTecnica;
}
