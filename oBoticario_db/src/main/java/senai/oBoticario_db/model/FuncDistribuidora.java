package senai.oBoticario_db.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Funcionarios_Distribuidora")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class FuncDistribuidora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FuncionariosID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "Distribuidora_ID", referencedColumnName = "Distribuidora_ID", nullable = false)
    private Distribuidora distribuidora;

    @Column(name = "Nome_Func", nullable = false)
    private String nome;

    @Column(name = "Email_Func", nullable = false, unique = true)
    private String email;

    @Column(name = "Senha_Func", nullable = false)
    private String senha;

    @Column(name = "Telefone_Func", columnDefinition = "CHAR(13)", nullable = false, unique = true)
    private String telefone;

    @Column(name = "Data_Nascimento_Func", nullable = false)
    @Past(message = "A data de nascimento deve ser no passado")
    private LocalDate dataNascimento;
}