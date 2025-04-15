package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.oBoticario_db.Repository.RevendedoresRepository;
import senai.oBoticario_db.model.*;

import java.util.List;
import java.util.Optional;

@Service
public class RevendedoresService {
    
    @Autowired
    private RevendedoresRepository revendedoresRepository;

    public List<Revendedores> listarTodos() {
        return revendedoresRepository.findAll();
    }

    public Optional<Revendedores> buscarPorId(long id) {
        return revendedoresRepository.findById(id);
    }

    public Revendedores salvar(Revendedores revendedore) {
        return revendedoresRepository.save(revendedore);
    }

    public Revendedores atualizar(long id, Revendedores revendedoresAtualizados) {
        return revendedoresRepository.findById(id).map(revendedore -> {
            revendedore.setNome(revendedoresAtualizados.getNome());
            revendedore.setEmail(revendedoresAtualizados.getEmail());
            revendedore.setSenha(revendedoresAtualizados.getSenha());
            revendedore.setTelefone(revendedoresAtualizados.getTelefone());
            revendedore.setEndereco(revendedoresAtualizados.getEndereco());
            revendedore.setData_nascimento(revendedoresAtualizados.getData_nascimento());
            return revendedoresRepository.save(revendedore);
        }).orElseThrow(() -> new RuntimeException("Revendedor não encontrado!"));
    }

    public void deletar(long id) {
        revendedoresRepository.deleteById(id);
    }

}
