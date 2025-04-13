package senai.oBoticario_db.model;

import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Produtos_Loja")
@Getter
@Setter
public class ProdutosLoja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProdutoID_Loja")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ProdutoID_Distr", nullable = false)
    private ProdutoDistribuidora produtoDistribuidora;

    @ManyToOne
    @JoinColumn(name = "LojaID", nullable = false)
    private Lojas loja;

    @Column(name = "Nome_Produto", length = 100, nullable = false)
    private String nome;

    @Column(name = "Descricao", length = 200, nullable = false)
    private String descricao;

    @Column(name = "Preco_Produto", precision = 10, scale = 2, nullable = false)
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
    private BigDecimal precoProduto;

    @Column(name = "Quantidade_Produto_Loja", nullable = false)
    private Integer quantidadeProdutoLoja;

    @ManyToOne
    @JoinColumn(name = "CategoriaID", nullable = false)
    private CategoriasProduto categoria;
    
    @Column(name = "Quantidade_Vendidos_Loja", nullable = false)
    private Integer quantidadeVendidosLoja;
}
