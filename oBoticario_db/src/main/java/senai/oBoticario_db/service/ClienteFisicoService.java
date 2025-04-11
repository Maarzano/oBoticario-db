package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.oBoticario_db.Repository.ClienteFisicoRepository;
import senai.oBoticario_db.model.ClienteFisico;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteFisicoService {

    @Autowired
    private ClienteFisicoRepository clienteFisicoRepository;

    public List<ClienteFisico> listarTodos() {
        return clienteFisicoRepository.findAll();
    }

    public Optional<ClienteFisico> buscarPorId(long id) {
        return clienteFisicoRepository.findById(id);
    }

    public ClienteFisico salvar(ClienteFisico cliente) {
        return clienteFisicoRepository.save(cliente);
    }

    public ClienteFisico atualizar(long id, ClienteFisico clienteAtualizado) {
        return clienteFisicoRepository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
            return clienteFisicoRepository.save(cliente);
        }).orElseThrow(() -> new RuntimeException("Cliente físico não encontrado!"));
    }

    public void deletar(long id) {
        clienteFisicoRepository.deleteById(id);
    }
}
