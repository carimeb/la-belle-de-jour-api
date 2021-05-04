package com.labelledejour.api.domain.entity;

public class Produto {

    private String nome;
    private String fichaTecnica;

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

}
