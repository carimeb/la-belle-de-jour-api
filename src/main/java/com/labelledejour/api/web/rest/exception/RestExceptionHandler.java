package com.labelledejour.api.web.rest.exception;

import com.labelledejour.api.data.produto.ProdutoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        var body = ExceptionResponse.of(ex.getBindingResult());
        return ResponseEntity.badRequest().body(body);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidProductId(ProdutoNaoEncontradoException ex) {
        var body = ExceptionResponse.of(ex.getMessage());
        return ResponseEntity.badRequest().body(body);
    }
}
