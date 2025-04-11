package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.oBoticario_db.Repository.FeriasRepository;
import senai.oBoticario_db.model.Ferias;

import java.util.List;
import java.util.Optional;

@Service
public class FeriasService {

    @Autowired
    private FeriasRepository feriasRepository;

    public List<Ferias> listarTodos() {
        return feriasRepository.findAll();
    }

    public Optional<Ferias> buscarPorId(long id) {
        return feriasRepository.findById(id);
    }

    public Ferias salvar(Ferias ferias) {
        return feriasRepository.save(ferias);
    }

    public Ferias atualizar(long id, Ferias feriasAtualizadas) {
        return feriasRepository.findById(id).map(ferias -> {
            ferias.setFuncionarioID(feriasAtualizadas.getFuncionarioID());
            ferias.setInicioFerias(feriasAtualizadas.getInicioFerias());
            ferias.setFimFerias(feriasAtualizadas.getFimFerias());
            ferias.setStatusAtualFerias(feriasAtualizadas.getStatusAtualFerias());
            return feriasRepository.save(ferias);
        }).orElseThrow(() -> new RuntimeException("Férias não encontradas!"));
    }

    public void deletar(long id) {
        feriasRepository.deleteById(id);
    }
}
