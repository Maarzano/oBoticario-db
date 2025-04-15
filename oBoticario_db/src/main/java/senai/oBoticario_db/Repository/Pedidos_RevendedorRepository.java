package senai.oBoticario_db.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import senai.oBoticario_db.model.PedidosRevendedor;

@Repository
public interface Pedidos_RevendedorRepository extends JpaRepository<PedidosRevendedor, Long>{
    
}
