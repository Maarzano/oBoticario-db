package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.PedidosRevendedor;
import senai.oBoticario_db.service.Pedidos_RevendedorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos_revendedor")
@Tag(name = "Pedidos Revendedor", description = "Operações relacionadas aos pedidos de revendedores")
public class PedidosRevendedorController {
    
    @Autowired
    private Pedidos_RevendedorService pedidos_RevendedorService;

    @GetMapping
    @Operation(summary = "Listar todos os pedidos de revendedores", description = "Retorna uma lista de todos os pedidos de revendedores cadastrados.")
    public List<PedidosRevendedor> listarTodos() {
        return pedidos_RevendedorService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pedido de revendedor por ID", description = "Retorna as informações de um pedido de revendedor com base no ID fornecido.")
    public ResponseEntity<PedidosRevendedor> buscarPorId(@PathVariable long id) {
        Optional<PedidosRevendedor> pedidos_Revendedo = pedidos_RevendedorService.buscarPorId(id);
        return pedidos_Revendedo.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo pedido de revendedor", description = "Cadastra um novo pedido de revendedor com as informações fornecidas.")
    public ResponseEntity<PedidosRevendedor> criar(@RequestBody PedidosRevendedor pedidos_RevendedorNova) {
        PedidosRevendedor pedidos_RevendedorSalva = pedidos_RevendedorService.salvar(pedidos_RevendedorNova);
        return ResponseEntity.ok(pedidos_RevendedorSalva);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar pedido de revendedor", description = "Atualiza as informações de um pedido de revendedor existente com base no ID fornecido.")
    public ResponseEntity<PedidosRevendedor> atualizar(@PathVariable long id, @RequestBody PedidosRevendedor pedidos_RevendedorAtualizado) {
        try {
            PedidosRevendedor atualizada = pedidos_RevendedorService.atualizar(id, pedidos_RevendedorAtualizado);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar pedido de revendedor", description = "Remove um pedido de revendedor do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        pedidos_RevendedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}