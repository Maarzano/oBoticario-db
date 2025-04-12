package senai.oBoticario_db.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pedidos_Revendedor")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Pedidos_Revendedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PedidoRevendedorID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "RevendedorID", referencedColumnName = "RevendedorID", nullable  = false)
    private BigDecimal revendedor;

    @Column(name = "ProdutoID", nullable = false)
    private BigDecimal produto;

    @Column(name = "Data_Pedido_Rev", nullable = false)
    private LocalDateTime data_pedido_rev;

    @Column(name = "Valor_Pedido_Rev", nullable = false)
    private  BigDecimal valor_pedido_rev;

    @Column(name = "Data_Nascimento_Rev", nullable = false)
    private LocalDateTime data_nascimento;

    @Column(name = "Status_Pedido", nullable = false)
    private String status_pedido;
}

/*CREATE TABLE Pedidos_Revendedor (

PedidoRevendedorID INT AUTO_INCREMENT PRIMARY KEY,

RevendedorID INT,

ProdutoID INT,

Data_Pedido_Rev DATETIME,

Valor_Pedido_Rev DECIMAL(10, 2) CHECK (Valor_Pedido_Rev > 0),

Status_Pedido ENUM('Enviado', 'Pendente', 'Entregue'),

FOREIGN KEY (RevendedorID) REFERENCES Revendedores(RevendedorID),

FOREIGN KEY (ProdutoID) REFERENCES Produtos_Distribuidora(ProdutoID) */