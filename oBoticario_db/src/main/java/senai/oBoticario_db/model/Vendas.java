package senai.oBoticario_db.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Vendas")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VendaID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "LojaID", referencedColumnName = "LojaID", nullable = false)
    private Lojas loja;

    @ManyToOne
    @JoinColumn(name = "FuncionarioID", referencedColumnName = "FuncionarioID", nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "ClienteID", referencedColumnName = "ClienteID", nullable = false)
    private ClienteFisico clienteFisico;

    @Column(name = "Data_Venda", nullable = false)
    @Past(message = "A data de venda deve ser no passado")
    private LocalDateTime dataVenda;

    @Column(name = "Total_Valor", nullable = false)
    @DecimalMin(value = "0.01", message = "O valor total deve ser maior que zero")
    private BigDecimal valorTotal;
    
}
