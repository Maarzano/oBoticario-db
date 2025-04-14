package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.oBoticario_db.repository.ProdDistribuidoraRepository;
import senai.oBoticario_db.model.ProdDistribuidora;

import java.util.List;
import java.util.Optional;

@Service
public class ProdDistribuidoraService {

    @Autowired
    private ProdDistribuidoraRepository prodDistribuidoraRepository;

    public List<ProdDistribuidora> listarTodos() {
        return prodDistribuidoraRepository.findAll();
    }

    public Optional<ProdDistribuidora> buscarPorId(long id) {
        return prodDistribuidoraRepository.findById(id);
    }

    public ProdDistribuidora salvar(ProdDistribuidora prodDistribuidora) {
        return prodDistribuidoraRepository.save(prodDistribuidora);
    }

    public ProdDistribuidora atualizar(long id, ProdDistribuidora prodDistribuidoraAtualizado) {
        return prodDistribuidoraRepository.findById(id).map(prod -> {
            prod.setDistribuidora(prodDistribuidoraAtualizado.getDistribuidora()); // Atualiza a distribuidora se necessário
            prod.setQuantidadeProdutos(prodDistribuidoraAtualizado.getQuantidadeProdutos());
            return prodDistribuidoraRepository.save(prod);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    public void deletar(long id) {
        prodDistribuidoraRepository.deleteById(id);
    }
}