package com.labelledejour.api.web.controller.oferta;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)  //indica que essa anotação servirá para uma propriedade, não uma classe
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorPreco.class)
public @interface PrecoValido {

    String message() default "Valor inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
