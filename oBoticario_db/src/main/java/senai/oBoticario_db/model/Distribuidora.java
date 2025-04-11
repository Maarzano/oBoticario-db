package senai.oBoticario_db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Distribuidora")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class Distribuidora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Distribuidora_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "Nome_Distr", length = 100, nullable = false)
    private String nome;

    @Column(name = "Telefone_Distr", length = 13, nullable = false)
    private String telefone;

    @Column(name = "CNPJ_Distr", length = 14, nullable = false)
    private Integer cnpj;
}
