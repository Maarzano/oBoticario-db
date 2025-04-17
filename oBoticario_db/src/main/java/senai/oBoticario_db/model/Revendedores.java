package senai.oBoticario_db.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.*;

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

    @Column(name = "Nome_Rev",length = 100, nullable  = false)
    private String nome;

    @Column(name = "Email_Rev",length = 60, nullable  = false, unique = true)
    private String email;

    @Column(name = "Senha_Rev",length = 200, nullable = false)
    private String senha;

    @Column(name = "Telefone_Rev",columnDefinition = "CHAR(13)", nullable = false, unique = true)
    private String telefone;

    @OneToOne
    @JoinColumn(name = "Endereco_ID", referencedColumnName = "Endereco_ID", nullable = false)
    private Endereco endereco;

    @Column(name = "Data_Nascimento_Rev", nullable = false)
    @Past(message = "A data de nascimento deve ser uma data passada")
    private LocalDateTime data_nascimento;
}