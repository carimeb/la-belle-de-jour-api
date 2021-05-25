package com.labelledejour.api.web.controller.oferta;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class ValidadorPreco implements ConstraintValidator<PrecoValido, String> {
    @Override
    public boolean isValid(String preco, ConstraintValidatorContext context) {
        try {
            new BigDecimal(preco);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
