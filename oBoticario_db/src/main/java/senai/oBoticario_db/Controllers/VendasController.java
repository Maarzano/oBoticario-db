package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Vendas;
import senai.oBoticario_db.service.VendasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendas")
@Tag(name = "Vendas", description = "Operações relacionadas às vendas")
public class VendasController {

    @Autowired
    private VendasService vendasService;

    @GetMapping
    @Operation(summary = "Listar todas as vendas", description = "Retorna uma lista de todas as vendas cadastradas.")
    public List<Vendas> listarTodos() {
        return vendasService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar venda por ID", description = "Retorna as informações de uma venda com base no ID fornecido.")
    public ResponseEntity<Vendas> buscarPorId(@PathVariable long id) {
        Optional<Vendas> venda = vendasService.buscarPorId(id);
        return venda.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar uma nova venda", description = "Cadastra uma nova venda com as informações fornecidas.")
    public ResponseEntity<Vendas> criar(@RequestBody Vendas novaVenda) {
        Vendas vendaSalva = vendasService.salvar(novaVenda);
        return ResponseEntity.ok(vendaSalva);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar venda", description = "Atualiza as informações de uma venda existente com base no ID fornecido.")
    public ResponseEntity<Vendas> atualizar(@PathVariable long id, @RequestBody Vendas vendaAtualizada) {
        try {
            Vendas atualizada = vendasService.atualizar(id, vendaAtualizada);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar venda", description = "Remove uma venda do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        vendasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}