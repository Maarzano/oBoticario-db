package senai.oBoticario_db.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Ferias")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Ferias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FeriasID")
    private long id;

    @OneToMany
    @JoinColumn(name = "FuncionarioID", referencedColumnName = "FuncionarioID", nullable = false)
    private Funcionario funcionarioID;

    @Column(name = "Data_Inicio_Ferias", nullable = false)
    private LocalDateTime inicioFerias;

    @Column(name = "Data_Fim_Ferias", nullable = false)
    private LocalDateTime fimFerias;

    @Column(name = "Status_Atual_Ferias", length = 20, nullable = false)
    private String statusAtualFerias;
}
