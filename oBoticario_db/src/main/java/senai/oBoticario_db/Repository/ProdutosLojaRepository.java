package senai.oBoticario_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senai.oBoticario_db.model.ProdutosLoja;

@Repository
public interface ProdutosLojaRepository extends JpaRepository<ProdutosLoja, Long> {
}
