package senai.oBoticario_db.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Revendedores")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Revendedores {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RevendedorID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "Nome_Rev", referencedColumnName = "Nome_Rev", nullable  = false)
    private String revendedores;

    @Column(name = "Senha_Rev", nullable = false)
    private BigDecimal senha;

    @Column(name = "Telefone_Rev", nullable = false)
    private BigDecimal telefone;

    @Column(name = "Endereco_ID", nullable = false)
    private Endereco endereco;

    @Column(name = "Data_Nascimento_Rev", nullable = false)
    private LocalDateTime data_nascimento
    @Past(message = "A data de nascimento deve ser uma data passada")
    private LocalDate dataNascimentoRev;
}