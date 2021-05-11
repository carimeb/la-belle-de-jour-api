package com.labelledejour.api.domain.entity;

import java.time.LocalDate;

public class Produto {

    private String nome;
    private String fichaTecnica;
    private LocalDate criadoEm;
    private LocalDate atualizadoEm;

    public Produto() {}

    public Produto(String nome, String fichaTecnica) {
        this.nome = nome;
        this.fichaTecnica = fichaTecnica;
        this.criadoEm = LocalDate.now();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(String fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public LocalDate getAtualizadoEm() { return atualizadoEm; }

    public void setAtualizadoEm(LocalDate dataAtualizacao) {
        this.atualizadoEm = dataAtualizacao;
    }

}
