package senai.oBoticario_db.model;

import jakarta.persistence.*;
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
    @JoinColumn(name = "DistribuidoraID", referencedColumnName = "DistribuidoraID", nullable = false)
    private Distribuidora distribuidora;  // FK para a tabela Distribuidoras

    @Column(name = "Nome_Func", nullable = false)
    private String nome;

    @Column(name = "Email_Func", nullable = false, unique = true)
    private String email;

    @Column(name = "Senha_Func", nullable = false)
    private String senha;

    @Column(name = "Telefone_Func", nullable = false, unique = true)
    private String telefone;

    @Column(name = "Data_Nascimento_Func", nullable = false)
    private LocalDate dataNascimento;
}