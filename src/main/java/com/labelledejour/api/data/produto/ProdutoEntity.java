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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(name = "ficha_tecnica", columnDefinition="VARCHAR(300)")
    private String fichaTecnica;

    @Column(name = "criado_em")
    private LocalDate criadoEm;

    @Column(name = "atualizado_em", nullable = true)
    private LocalDate atualizadoEm;

    public static ProdutoEntity of(Produto produto) {  //transformo a entidade Produto do domain para a entidade Produto do BD
        return ProdutoEntity.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .fichaTecnica(produto.getFichaTecnica())
                .criadoEm(produto.getCriadoEm())
                .atualizadoEm(produto.getAtualizadoEm())
                .build();
    }

    public Produto toProduto() {     //transformo uma entidade Produto do BD para a entidade "Produto" do domain
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setNome(this.nome);
        produto.setFichaTecnica(this.fichaTecnica);
        produto.setCriadoEm(this.criadoEm);
        produto.setAtualizadoEm(this.atualizadoEm);

        return produto;
    }

}
