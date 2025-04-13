package senai.oBoticario_db.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Categorias_Produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriasProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoriaID")
    private Long id;

    @Column(name = "Nome_Categoria", length = 100, nullable = false)
    private String nome;
}
