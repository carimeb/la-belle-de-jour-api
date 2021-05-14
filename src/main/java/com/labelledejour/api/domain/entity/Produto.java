package com.labelledejour.api.domain.entity;

import java.time.LocalDate;

public class Produto {

    private long id;
    private String nome;
    private String fichaTecnica;
    private LocalDate criadoEm;   //TODO corrigir no update
    private LocalDate atualizadoEm;   //TODO corrigir no update

    public Produto() {}

    public Produto(long id, String nome, String fichaTecnica) {
        this(nome, fichaTecnica);
        this.id = id;
    }

    public Produto(String nome, String fichaTecnica) {
        this.nome = nome;
        this.fichaTecnica = fichaTecnica;
        this.criadoEm = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDate getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDate atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
