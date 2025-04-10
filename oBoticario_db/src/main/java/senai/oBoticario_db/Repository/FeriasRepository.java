package senai.oBoticario_db.Repository;

import senai.oBoticario_db.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeriasRepository extends JpaRepository<Ferias, Long> {
}