package senai.oBoticario_db.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.*;

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
    @JoinColumn(name = "DistribuidoraID", referencedColumnName = "Distribuidora_ID", nullable = false)
    private Distribuidora distribuidoraId;

    @Column(name = "NumeroRemessa", nullable = false, unique = true)
    private int numeroRemessa;

    @Column(name = "DataEnvioRemessa", nullable = false)
    @Past(message = "A data de envio deve ser no passado")
    private LocalDateTime dataEnvioRemessa;

    @Column(name = "RotasLojas", nullable = false)
    private String rotasLojas;
}