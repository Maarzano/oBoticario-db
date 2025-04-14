package senai.oBoticario_db.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Itens_Venda")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ItensVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItenVendaID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "VendaID", referencedColumnName = "VendaID", nullable = false)
    private Vendas venda;

    @ManyToOne
    @JoinColumn(name = "Produto", referencedColumnName = "LojaID", nullable = false)
    private Lojas loja;


}
