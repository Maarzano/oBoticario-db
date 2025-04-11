package senai.oBoticario_db.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Clientes_Fisicos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ClienteFisico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClienteID")
    private long id;

    @Column(name = "Nome_Cliente", length = 100, nullable = false)
    private String nome;

    @Column(name = "Email_Cliente", length = 200, nullable = false, unique = true)
    private String email;

    @Column(name = "Telefone_Cliente", length = 13, nullable = false, unique = true)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "Endereco_ID", referencedColumnName = "Endereco_ID", nullable = false)
    private Endereco endereco;

    @Column(name = "Data_Nasc_Cliente", nullable = false)
    private LocalDate dataNascimento;
}
