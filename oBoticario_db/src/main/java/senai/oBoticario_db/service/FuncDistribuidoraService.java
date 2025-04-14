package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.oBoticario_db.repository.FuncDistribuidoraRepository;
import senai.oBoticario_db.model.FuncDistribuidora;

import java.util.List;
import java.util.Optional;

@Service
public class FuncDistribuidoraService {

    @Autowired
    private FuncDistribuidoraRepository funcDistribuidoraRepository;

    public List<FuncDistribuidora> listarTodos() {
        return funcDistribuidoraRepository.findAll();
    }

    public Optional<FuncDistribuidora> buscarPorId(long id) {
        return funcDistribuidoraRepository.findById(id);
    }

    public FuncDistribuidora salvar(FuncDistribuidora funcDistribuidora) {
        return funcDistribuidoraRepository.save(funcDistribuidora);
    }

    public FuncDistribuidora atualizar(long id, FuncDistribuidora funcDistribuidoraAtualizado) {
        return funcDistribuidoraRepository.findById(id).map(func -> {
            func.setDistribuidora(funcDistribuidoraAtualizado.getDistribuidora());
            func.setNome(funcDistribuidoraAtualizado.getNome());
            func.setEmail(funcDistribuidoraAtualizado.getEmail());
            func.setSenha(funcDistribuidoraAtualizado.getSenha());
            func.setTelefone(funcDistribuidoraAtualizado.getTelefone());
            func.setDataNascimento(funcDistribuidoraAtualizado.getDataNascimento());
            return funcDistribuidoraRepository.save(func);
        }).orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
    }

    public void deletar(long id) {
        funcDistribuidoraRepository.deleteById(id);
    }
}