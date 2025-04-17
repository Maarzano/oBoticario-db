package senai.oBoticario_db.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Past;
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
    @DecimalMin(value = "0.01", message = "O pagamento deve ser maior que zero")
    private BigDecimal pagamento_Bruto;

    @Column(name = "Pagamento_Valor_Bonus", nullable = false)
    @DecimalMin(value = "0.01", message = "O pagamento deve ser maior que zero")
    private BigDecimal pagamento_Bonus;

    @Column(name = "Data_Pagamento", nullable = false)
    @Past(message = "A data de pagamento deve ser no passado")
    private LocalDateTime data_Pagamento;
}
