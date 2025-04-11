package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.oBoticario_db.Repository.LojasRepository;
import senai.oBoticario_db.model.Lojas;

import java.util.List;
import java.util.Optional;

@Service
public class LojasService {

    @Autowired
    private LojasRepository lojasRepository;

    public List<Lojas> listarTodos() {
        return lojasRepository.findAll();
    }

    public Optional<Lojas> buscarPorId(long id) {
        return lojasRepository.findById(id);
    }

    public Lojas salvar(Lojas loja) {
        return lojasRepository.save(loja);
    }

    public Lojas atualizar(long id, Lojas lojaAtualizada) {
        return lojasRepository.findById(id).map(loja -> {
            loja.setNomeLoja(lojaAtualizada.getNomeLoja());
            loja.setEndereco(lojaAtualizada.getEndereco());
            return lojasRepository.save(loja);
        }).orElseThrow(() -> new RuntimeException("Loja não encontrada!"));
    }

    public void deletar(long id) {
        lojasRepository.deleteById(id);
    }
}
