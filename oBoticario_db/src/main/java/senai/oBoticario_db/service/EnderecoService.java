package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.oBoticario_db.Repository.EnderecoRepository;
import senai.oBoticario_db.model.*;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarPorId(long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizar(long id, Endereco enderecoAtualizado) {
        return enderecoRepository.findById(id).map(end -> {
            end.setRua(enderecoAtualizado.getRua());
            end.setNumero(enderecoAtualizado.getNumero());
            end.setBairro(enderecoAtualizado.getBairro());
            end.setCidade(enderecoAtualizado.getCidade());
            end.setUf(enderecoAtualizado.getUf());
            end.setCep(enderecoAtualizado.getCep());
            return enderecoRepository.save(end);
        }).orElseThrow(() -> new RuntimeException("Endereço não encontrado!"));
    }

    public void deletar(long id) {
        enderecoRepository.deleteById(id);
    }
}