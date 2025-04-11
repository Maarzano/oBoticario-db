package senai.oBoticario_db.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Lojas")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Lojas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LojaID")
    private long id;

    @Column(name = "Nome_Loja", length = 100, nullable = false)
    private String nomeLoja;

    @OneToOne
    @JoinColumn(name = "Endereco_ID", referencedColumnName = "Endereco_ID", nullable = false)
    private Endereco endereco;
}
