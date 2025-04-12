package senai.oBoticario_db.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "EnviosPedidoLoja")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EnviosPedidoLoja {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EnviosPedidosLojaID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "DistribuidoraID", referencedColumnName = "DistribuidoraID", nullable = false)
    private BigDecimal distribuidora;

    @ManyToOne
    @JoinColumn(name = "NumeroRemessa", referencedColumnName = "NumeroRemessa", nullable = false)
    private BigDecimal numeroRemessa;

    @ManyToOne
    @JoinColumn(name = "DataEnvioRemessa", referencedColumnName = "DataEnvioRemessa", nullable = false)
    private LocalDateTime dataEnvioRemessa;

    @Column(name = "RotasLojas", nullable = false)
    private String rotasLojas;
}