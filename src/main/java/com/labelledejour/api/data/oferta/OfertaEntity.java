package com.labelledejour.api.data.oferta;

import com.labelledejour.api.data.produto.ProdutoEntity;
import com.labelledejour.api.domain.entity.Oferta;
import com.labelledejour.api.domain.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@Table(name = "OFERTAS")
@AllArgsConstructor
@NoArgsConstructor
public class OfertaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal preco;

    private String ofertante;

    @Column(name = "expira_em")
    private LocalDate expiraEm;

    @Column(name = "redirect_link", columnDefinition = "VARCHAR(300)")
    private String redirectLink;

    @ManyToOne  //cardinalidade: "many" OfertaEntity "toOne" ProdutoEntity
    private ProdutoEntity produtoEntity;

    public static OfertaEntity from(Oferta oferta) {  //Pq usamos from ao invés de of, como em ProdutoEntity?
        return OfertaEntity.builder()
                .id(oferta.getId())
                .preco(oferta.getPreco())
                .ofertante(oferta.getOfertante())
                .expiraEm(oferta.getExpiraEm())
                .redirectLink(oferta.getRedirectLink())
                .produtoEntity(ProdutoEntity.builder().id(oferta.getProduto().getId()).build())
                .build();
    }

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setId(this.id);
        oferta.setPreco(this.preco);
        oferta.setOfertante(this.ofertante);
        oferta.setExpiraEm(this.expiraEm);
        oferta.setRedirectLink(this.redirectLink);
        oferta.setProduto(this.produtoEntity.toProduto());

        return oferta;
    }
}
