package com.labelledejour.api.data.produto;

public class ProdutoNaoEncontradoException extends RuntimeException{

    public ProdutoNaoEncontradoException() {
        super("Produto não encontrado.");
    }
}
