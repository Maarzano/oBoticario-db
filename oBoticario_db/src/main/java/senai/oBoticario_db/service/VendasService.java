package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.oBoticario_db.Repository.VendasRepository;
import senai.oBoticario_db.model.*;

import java.util.List;
import java.util.Optional;

@Service
public class VendasService {

    @Autowired
    private VendasRepository vendasRepository;

    public List<Vendas> listarTodos() {
        return vendasRepository.findAll();
    }

    public Optional<Vendas> buscarPorId(long id) {
        return vendasRepository.findById(id);
    }

    public Vendas salvar(Vendas venda) {
        return vendasRepository.save(venda);
    }

    public Vendas atualizar(long id, Vendas vendaAtualizada) {
        return vendasRepository.findById(id).map(venda -> {
            venda.setLoja(vendaAtualizada.getLoja());
            venda.setFuncionario(vendaAtualizada.getFuncionario());
            venda.setClienteFisico(vendaAtualizada.getClienteFisico());
            venda.setDataVenda(vendaAtualizada.getDataVenda());
            venda.setValorTotal(vendaAtualizada.getValorTotal());
            return vendasRepository.save(venda);
        }).orElseThrow(() -> new RuntimeException("venda não encontrado!"));
    }

    public void deletar(long id) {
        vendasRepository.deleteById(id);
    }
}
