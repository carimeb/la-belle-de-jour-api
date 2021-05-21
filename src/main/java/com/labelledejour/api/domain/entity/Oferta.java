package com.labelledejour.api.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Oferta {

    private long id;
    private BigDecimal preco;
    private String ofertante;
    private LocalDate expiraEm;
    private String redirectLink;
    private Produto produto;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getOfertante() {
        return ofertante;
    }

    public void setOfertante(String ofertante) {
        this.ofertante = ofertante;
    }

    public LocalDate getExpiraEm() {
        return expiraEm;
    }

    public void setExpiraEm(LocalDate expiraEm) {
        this.expiraEm = expiraEm;
    }

    public String getRedirectLink() {
        return redirectLink;
    }

    public void setRedirectLink(String redirectLink) {
        this.redirectLink = redirectLink;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
