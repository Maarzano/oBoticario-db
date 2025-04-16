package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Pagamentos;
import senai.oBoticario_db.service.PagamentosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamentos")
@Tag(name = "Pagamentos", description = "Operações relacionadas aos pagamentos")
public class PagamentosController {

    @Autowired
    private PagamentosService pagamentosService;

    @GetMapping
    @Operation(summary = "Listar todos os pagamentos", description = "Retorna uma lista de todos os pagamentos cadastrados.")
    public List<Pagamentos> listarTodos() {
        return pagamentosService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pagamento por ID", description = "Retorna as informações de um pagamento com base no ID fornecido.")
    public ResponseEntity<Pagamentos> buscarPorId(@PathVariable long id) {
        Optional<Pagamentos> pagamento = pagamentosService.buscarPorId(id);
        return pagamento.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo pagamento", description = "Cadastra um novo pagamento com as informações fornecidas.")
    public ResponseEntity<Pagamentos> criar(@RequestBody Pagamentos novoPagamento) {
        Pagamentos pagamentoSalvo = pagamentosService.salvar(novoPagamento);
        return ResponseEntity.ok(pagamentoSalvo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar pagamento", description = "Atualiza as informações de um pagamento existente com base no ID fornecido.")
    public ResponseEntity<Pagamentos> atualizar(@PathVariable long id, @RequestBody Pagamentos pagamentoAtualizado) {
        try {
            Pagamentos atualizado = pagamentosService.atualizar(id, pagamentoAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar pagamento", description = "Remove um pagamento do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        pagamentosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}