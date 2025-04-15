package senai.oBoticario_db.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Itens_Venda")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ItensVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemVendaID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "VendaID", referencedColumnName = "VendaID", nullable = false)
    private Vendas vendaID;

    @ManyToOne
    @JoinColumn(name = "ProdutoID_Loja", referencedColumnName = "ProdutoID_Loja", nullable = false)
    private ProdutosLoja produtosLoja;

    @Column(name = "Quantidade")
    private long Quantidade;

    @Column(name = "Preco_Unitario")
    private BigDecimal Preco_Unitario;


}
