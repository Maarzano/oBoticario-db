package senai.oBoticario_db.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import senai.oBoticario_db.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
