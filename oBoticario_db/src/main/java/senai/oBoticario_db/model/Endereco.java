package senai.oBoticario_db.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Enderecos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Endereco_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "Endereco_Rua", length = 40, nullable = false)
    private String rua;

    @Column(name = "Endereco_Numero", nullable = false)
    private Integer numero;

    @Column(name = "Endereco_Bairro", length = 40, nullable = false)
    private String bairro;

    @Column(name = "Endereco_Cidade", length = 40, nullable = false)
    private String cidade;

    @Column(name = "Endereco_UF", columnDefinition = "CHAR(2)", nullable = false)
    private String uf;

    @Column(name = "Endereco_CEP", length = 10, nullable = false)
    private String cep;
}
