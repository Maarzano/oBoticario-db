package senai.oBoticario_db.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Funcionarios")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FuncionarioID")
    private long id;

    @Column(name = "Nome_Func", length = 100, nullable = false)
    private String nome;

    @Column(name = "Email_Func", length = 320, nullable = false, unique = true)
    private String email;

    @Column(name = "CPF_Func", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "Telefone_Func", length = 13, unique = true)
    private String telefone;

    @Column(name = "Data_Nasc_Func", nullable = false)
    @Past(message = "A data de nascimento deve ser uma data passada")
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "Endereco_ID", referencedColumnName = "Endereco_ID", nullable = false)
    private Endereco endereco;

    @Column(name = "Cargo_Func", length = 30, nullable = false)
    private String cargo;

    @Column(name = "Salario_Func", nullable = false)
    @DecimalMin(value = "0.01", message = "O salário deve ser maior que zero")
    private BigDecimal salario;

    @Column(name = "Data_Admissao_Func", nullable = false)
    private LocalDateTime dataAdmissao;

}
