package com.labelledejour.api.domain.entity;

import java.time.LocalDate;

public class Produto {

    private String nome;
    private String fichaTecnica;
    private LocalDate criadoEm;
    private LocalDate atualizadoEm;

    public Produto(String nome, String fichaTecnica) {
        this.nome = nome;
        this.fichaTecnica = fichaTecnica;
        this.criadoEm = LocalDate.now();
    }

    public String getNome() {
        return nome;
    }

    public String getFichaTecnica() {
        return fichaTecnica;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public LocalDate getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDate dataAtualizacao) {
        this.atualizadoEm = dataAtualizacao;
    }

}
