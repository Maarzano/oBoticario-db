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

    @ManyToOne
    @JoinColumn(name = "FuncionarioID", referencedColumnName = "FuncionarioID", nullable = false)
    private Funcionario funcionarioID;

    @Column(name = "Data_Inicio_Ferias", nullable = false)
    private LocalDateTime inicioFerias;

    @Column(name = "Data_Fim_Ferias", nullable = false)
    private LocalDateTime fimFerias;

public void setInicioFerias(LocalDateTime inicioFerias) {
    this.inicioFerias = inicioFerias;
}

public void setFimFerias(LocalDateTime fimFerias) {
    if (this.inicioFerias != null && fimFerias != null && fimFerias.isBefore(this.inicioFerias)) {
        throw new IllegalArgumentException("Data de fim de férias deve ser depois da data de início.");
    }
    this.fimFerias = fimFerias;
}



    @Column(name = "Status_Atual_Ferias", length = 20, nullable = false)
    private String statusAtualFerias;
}
