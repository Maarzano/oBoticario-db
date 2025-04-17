package senai.oBoticario_db.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Produtos_Distribuidora")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ProdDistribuidora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProdutoID_Distr")
    private long id;

    @ManyToOne
    @JoinColumn(name = "Distribuidora_ID", referencedColumnName = "Distribuidora_ID", nullable = false)
    private Distribuidora distribuidora;

    @Column(name = "Quantidade_Produtos_Distr", nullable = false)
    private int quantidadeProdutos;
}