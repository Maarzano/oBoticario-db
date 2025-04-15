package senai.oBoticario_db.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pedidos_Revendedor")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PedidosRevendedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PedidoRevendedorID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "RevendedorID", referencedColumnName = "RevendedorID", nullable  = false)
    private Revendedores revendedor;

    @ManyToOne
    @JoinColumn(name = "ProdutoID", referencedColumnName = "ProdutoID_Distr",  nullable = false)
    private ProdDistribuidora produto;

    @Column(name = "Data_Pedido_Rev", nullable = false)
    private LocalDateTime data_pedido_rev;
    
    @Column(name = "Valor_Pedido_Rev", nullable = false)
    @DecimalMin(value = "0.01", message = "O valor do pedido deve ser maior que zero")
    private BigDecimal valorPedidoRev;

    @Column(name = "Status_Pedido", nullable = false)
    private String status_pedido;
}