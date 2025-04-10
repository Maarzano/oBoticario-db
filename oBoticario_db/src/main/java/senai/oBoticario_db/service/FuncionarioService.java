package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.oBoticario_db.Repository.FuncionarioRepository;
import senai.oBoticario_db.model.*;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarPorId(long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(long id, Funcionario funcionarioAtualizado) {
        return funcionarioRepository.findById(id).map(func -> {
            func.setNome(funcionarioAtualizado.getNome());
            func.setEmail(funcionarioAtualizado.getEmail());
            func.setCpf(funcionarioAtualizado.getCpf());
            func.setTelefone(funcionarioAtualizado.getTelefone());
            func.setDataNascimento(funcionarioAtualizado.getDataNascimento());
            func.setCargo(funcionarioAtualizado.getCargo());
            func.setSalario(funcionarioAtualizado.getSalario());
            func.setDataAdmissao(funcionarioAtualizado.getDataAdmissao());
            func.setEndereco(funcionarioAtualizado.getEndereco());
            return funcionarioRepository.save(func);
        }).orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
    }

    public void deletar(long id) {
        funcionarioRepository.deleteById(id);
    }
}
