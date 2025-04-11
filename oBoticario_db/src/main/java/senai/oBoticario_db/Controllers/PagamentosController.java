package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Pagamentos;
import senai.oBoticario_db.service.PagamentosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamentos")
public class PagamentosController {

    @Autowired
    private PagamentosService pagamentosService;

    @GetMapping
    public List<Pagamentos> listarTodos() {
        return pagamentosService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamentos> buscarPorId(@PathVariable long id) {
        Optional<Pagamentos> pagamento = pagamentosService.buscarPorId(id);
        return pagamento.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pagamentos> criar(@RequestBody Pagamentos novoPagamento) {
        Pagamentos pagamentoSalvo = pagamentosService.salvar(novoPagamento);
        return ResponseEntity.ok(pagamentoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamentos> atualizar(@PathVariable long id, @RequestBody Pagamentos pagamentoAtualizado) {
        try {
            Pagamentos atualizado = pagamentosService.atualizar(id, pagamentoAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        pagamentosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
