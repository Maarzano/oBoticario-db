package senai.oBoticario_db.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pagamentos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class Pagamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PagamentoID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "FuncionarioID", referencedColumnName = "FuncionarioID", nullable = false)
    private Funcionario funcionario;

    @Column(name = "Pagamento_Valor_Bruto", nullable = false)
    private BigDecimal pagamento_Bruto
    @DecimalMin(value = "0.01", message = "O pagamento deve ser maior que zero")
    private BigDecimal pagamentoValorBruto;

    @Column(name = "Pagamento_Valor_Bonus", nullable = false)
    private BigDecimal pagamento_Bonus
    @DecimalMin(value = "0.01", message = "O pagamento deve ser maior que zero")
    private BigDecimal Pagamento_Valor_Bonus;

    @Column(name = "Data_Pagamento", nullable = false)
    private LocalDateTime data_Pagamento;
}
