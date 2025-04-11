package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.oBoticario_db.Repository.DistribuidoraRepository;
import senai.oBoticario_db.model.*;

import java.util.List;
import java.util.Optional;

@Service
public class DistribuidoraService {
    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    public List<Distribuidora> listarTodos() {
        return distribuidoraRepository.findAll();
    }

    public Optional<Distribuidora> buscarPorId(long id) {
        return distribuidoraRepository.findById(id);
    }

    public Distribuidora salvar(Distribuidora distribuidora) {
        return distribuidoraRepository.save(distribuidora);
    }

    public Distribuidora atualizar(long id, Distribuidora distribuidoraAtualizado) {
        return distribuidoraRepository.findById(id).map(distribuidora -> {
            distribuidora.setNome(distribuidoraAtualizado.getNome());
            distribuidora.setTelefone(distribuidoraAtualizado.getTelefone());
            distribuidora.setCnpj(distribuidoraAtualizado.getCnpj());
            return distribuidoraRepository.save(distribuidora);
        }).orElseThrow(() -> new RuntimeException("Distribuidora não encontrada!"));
    }

    public void deletar(long id) {
        distribuidoraRepository.deleteById(id);
    }
}