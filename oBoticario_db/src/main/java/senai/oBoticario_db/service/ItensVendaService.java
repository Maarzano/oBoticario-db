package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.oBoticario_db.Repository.ItensVendaRepository;
import senai.oBoticario_db.model.ItensVenda;

import java.util.List;
import java.util.Optional;

@Service
public class ItensVendaService {

    @Autowired
    private ItensVendaRepository itemVendaRepository;

    public List<ItensVenda> listarTodos() {
        return itemVendaRepository.findAll();
    }

    public Optional<ItensVenda> buscarPorId(long id) {
        return itemVendaRepository.findById(id);
    }

    public ItensVenda salvar(ItensVenda itemVenda) {
        return itemVendaRepository.save(itemVenda);
    }

    public ItensVenda atualizar(long id, ItensVenda itemVendaAtualizado) {
        return itemVendaRepository.findById(id).map(item -> {
            item.setVendaID(itemVendaAtualizado.getVendaID());
            item.setProdutosLoja(itemVendaAtualizado.getProdutosLoja());
            item.setQuantidade(itemVendaAtualizado.getQuantidade());
            item.setPreco_Unitario(itemVendaAtualizado.getPreco_Unitario());
            return itemVendaRepository.save(item);
        }).orElseThrow(() -> new RuntimeException("Item de venda não encontrado!"));
    }

    public void deletar(long id) {
        itemVendaRepository.deleteById(id);
    }
}