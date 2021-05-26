package com.labelledejour.api.data.oferta;

public class OfertaNaoEncontradaException extends RuntimeException {

    public OfertaNaoEncontradaException() {
        super("Oferta não encontrada.");
    }
}
