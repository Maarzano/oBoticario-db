package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.oBoticario_db.Repository.AusenciasRepository;
import senai.oBoticario_db.model.Ausencias;

import java.util.List;
import java.util.Optional;

@Service
public class AusenciasService {

    @Autowired
    private AusenciasRepository ausenciasRepository;

    public List<Ausencias> listarTodos() {
        return ausenciasRepository.findAll();
    }

    public Optional<Ausencias> buscarPorId(long id) {
        return ausenciasRepository.findById(id);
    }

    public Ausencias salvar(Ausencias ausencia) {
        return ausenciasRepository.save(ausencia);
    }

    public Ausencias atualizar(long id, Ausencias ausenciaAtualizada) {
        return ausenciasRepository.findById(id).map(ausencia -> {
            ausencia.setFuncionarioID(ausenciaAtualizada.getFuncionarioID());
            ausencia.setInicioAusencia(ausenciaAtualizada.getInicioAusencia());
            ausencia.setFimAusencia(ausenciaAtualizada.getFimAusencia());
            ausencia.setMotivoAusencia(ausenciaAtualizada.getMotivoAusencia());
            return ausenciasRepository.save(ausencia);
        }).orElseThrow(() -> new RuntimeException("Ausência não encontrada!"));
    }

    public void deletar(long id) {
        ausenciasRepository.deleteById(id);
    }
}
