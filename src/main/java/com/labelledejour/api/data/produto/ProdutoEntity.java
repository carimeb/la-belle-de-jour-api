package com.labelledejour.api.data.produto;

import com.labelledejour.api.domain.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Table(name = "PRODUTOS")
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @Column(name = "ficha_tecnica", columnDefinition="VARCHAR(300)")
    private String fichaTecnica;

    @Column(name = "criado_em")
    private LocalDate criadoEm;

    @Column(name = "atualizado_em", nullable = true)
    private LocalDate atualizadoEm;

    public static ProdutoEntity of(Produto produto) {
        return ProdutoEntity.builder()
                .nome(produto.getNome())
                .fichaTecnica(produto.getFichaTecnica())
                .criadoEm(produto.getCriadoEm())
                .atualizadoEm(produto.getAtualizadoEm())
                .build();
    }

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setNome(this.nome);
        produto.setFichaTecnica(this.fichaTecnica);
        produto.setCriadoEm(this.criadoEm);
        produto.setAtualizadoEm(this.atualizadoEm);

        return produto;
    }

}
