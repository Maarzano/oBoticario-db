package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.oBoticario_db.Repository.Pedidos_RevendedorRepository;
import senai.oBoticario_db.model.*;

import java.util.List;
import java.util.Optional;

@Service
public class Pedidos_RevendedorService {
    
    @Autowired
    private Pedidos_RevendedorRepository pedidos_RevendedorRepository;

    public List<Pedidos_Revendedor> listarTodos() {
        return pedidos_RevendedorRepository.findAll();
    }

    public Optional<Pedidos_Revendedor> buscarPorId(long id) {
        return pedidos_RevendedorRepository.findById(id);
    }

    public Pedidos_Revendedor salvar(Pedidos_Revendedor Pedidos_Revendedo) {
        return pedidos_RevendedorRepository.save(Pedidos_Revendedo);
    }

    public Pedidos_Revendedor atualizar(long id, Pedidos_Revendedor pedidos_RevendedorAtualizado) {
        return pedidos_RevendedorRepository.findById(id).map(Pedidos_Revendedo -> {
            Pedidos_Revendedo.setRevendedor(pedidos_RevendedorAtualizado.getRevendedor());
            Pedidos_Revendedo.setProduto(pedidos_RevendedorAtualizado.getProduto());
            Pedidos_Revendedo.setData_pedido_rev(pedidos_RevendedorAtualizado.getData_pedido_rev());
            Pedidos_Revendedo.setValor_pedido_rev(pedidos_RevendedorAtualizado.getValor_pedido_rev());
            Pedidos_Revendedo.setData_nascimento(pedidos_RevendedorAtualizado.getData_nascimento());
            Pedidos_Revendedo.setStatus_pedido(pedidos_RevendedorAtualizado.getStatus_pedido());
            return pedidos_RevendedorRepository.save(Pedidos_Revendedo);
        }).orElseThrow(() -> new RuntimeException("Pedido do Revendedor não encontrado!"));
    }

    public void deletar(long id) {
        pedidos_RevendedorRepository.deleteById(id);
    }
}
