package senai.oBoticario_db.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senai.oBoticario_db.model.EnviosPedidoLoja;

@Repository
public interface EnviosPedidoLojaRepository extends JpaRepository<EnviosPedidoLoja, Long>{
    
}
