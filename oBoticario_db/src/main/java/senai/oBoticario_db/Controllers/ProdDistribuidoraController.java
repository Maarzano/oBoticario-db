package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.ProdDistribuidora;
import senai.oBoticario_db.service.ProdDistribuidoraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos_Distribuidora")
@Tag(name = "Produtos Distribuidora", description = "Operações relacionadas aos produtos de distribuidora")
public class ProdDistribuidoraController {

    @Autowired
    private ProdDistribuidoraService prodDistribuidoraService;

    @GetMapping
    @Operation(summary = "Listar todos os produtos da distribuidora", description = "Retorna uma lista de todos os produtos disponíveis na distribuidora.")
    public List<ProdDistribuidora> listarTodos() {
        return prodDistribuidoraService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto da distribuidora por ID", description = "Retorna as informações de um produto da distribuidora com base no ID fornecido.")
    public ResponseEntity<ProdDistribuidora> buscarPorId(@PathVariable long id) {
        Optional<ProdDistribuidora> produto = prodDistribuidoraService.buscarPorId(id);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo produto da distribuidora", description = "Cadastra um novo produto da distribuidora com as informações fornecidas.")
    public ResponseEntity<ProdDistribuidora> criar(@RequestBody ProdDistribuidora novoProduto) {
        ProdDistribuidora produtoSalvo = prodDistribuidoraService.salvar(novoProduto);
        return ResponseEntity.ok(produtoSalvo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar produto da distribuidora", description = "Atualiza as informações de um produto da distribuidora existente com base no ID fornecido.")
    public ResponseEntity<ProdDistribuidora> atualizar(@PathVariable long id, @RequestBody ProdDistribuidora produtoAtualizado) {
        try {
            ProdDistribuidora atualizado = prodDistribuidoraService.atualizar(id, produtoAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar produto da distribuidora", description = "Remove um produto da distribuidora do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        prodDistribuidoraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}