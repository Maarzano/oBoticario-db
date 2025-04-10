package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.oBoticario_db.Repository.PagamentosRepository;
import senai.oBoticario_db.model.*;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentosService {

    @Autowired
    private PagamentosRepository pagamentosRepository;

    public List<Pagamentos> listarTodos() {
        return pagamentosRepository.findAll();
    }

    public Optional<Pagamentos> buscarPorId(long id) {
        return pagamentosRepository.findById(id);
    }

    public Pagamentos salvar(Pagamentos pagamento) {
        return pagamentosRepository.save(pagamento);
    }

    public Pagamentos atualizar(long id, Pagamentos pagamentoAtualizado) {
        return pagamentosRepository.findById(id).map(pagamento -> {
            pagamento.setFuncionario(pagamentoAtualizado.getFuncionario());
            pagamento.setPagamento_Bruto(pagamentoAtualizado.getPagamento_Bruto());
            pagamento.setPagamento_Bonus(pagamentoAtualizado.getPagamento_Bonus());
            pagamento.setData_Pagamento(pagamentoAtualizado.getData_Pagamento());
            return pagamentosRepository.save(pagamento);
        }).orElseThrow(() -> new RuntimeException("Pagamento não encontrado!"));
    }

    public void deletar(long id) {
        pagamentosRepository.deleteById(id);
    }
}
