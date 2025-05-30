package senai.oBoticario_db.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Ausencias")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Ausencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AusenciaID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "FuncionarioID", referencedColumnName = "FuncionarioID", unique = false, nullable = false)
    private Funcionario funcionarioID;
    
    @Column(name = "Data_Inicio_Ausencia", nullable = false)
    private LocalDateTime inicioAusencia;
        
    @Column(name = "Data_Fim_Ausencia", nullable = false)
    private LocalDateTime fimAusencia;
    
    public void setInicioAusencia(LocalDateTime inicioAusencia) {
        this.inicioAusencia = inicioAusencia;
    }
    
    public void setFimAusencia(LocalDateTime fimAusencia) {
        if (this.inicioAusencia != null && fimAusencia != null && fimAusencia.isBefore(this.inicioAusencia)) {
            throw new IllegalArgumentException("Data de fim da ausência deve ser depois da data de início.");
        }
        this.fimAusencia = fimAusencia;
    }
    

    @Column(name = "Motivo_Ausencia", length = 500, nullable = false)
    private String motivoAusencia;
}
