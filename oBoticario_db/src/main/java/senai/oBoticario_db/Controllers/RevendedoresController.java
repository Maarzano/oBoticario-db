package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Revendedores;
import senai.oBoticario_db.service.RevendedoresService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/revendedores")
@Tag(name = "Revendedores", description = "Operações relacionadas aos revendedores")
public class RevendedoresController {
    
    @Autowired
    private RevendedoresService revendedoresService;

    @GetMapping
    @Operation(summary = "Listar todos os revendedores", description = "Retorna uma lista de todos os revendedores cadastrados.")
    public List<Revendedores> listarTodos() {
        return revendedoresService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar revendedor por ID", description = "Retorna as informações de um revendedor com base no ID fornecido.")
    public ResponseEntity<Revendedores> buscarPorId(@PathVariable long id) {
        Optional<Revendedores> revendedore = revendedoresService.buscarPorId(id);
        return revendedore.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo revendedor", description = "Cadastra um novo revendedor com as informações fornecidas.")
    public ResponseEntity<Revendedores> criar(@RequestBody Revendedores novoRevendedor) {
        Revendedores revendedorSalvo = revendedoresService.salvar(novoRevendedor);
        return ResponseEntity.ok(revendedorSalvo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar revendedor", description = "Atualiza as informações de um revendedor existente com base no ID fornecido.")
    public ResponseEntity<Revendedores> atualizar(@PathVariable long id, @RequestBody Revendedores revendedorAtualizado) {
        try {
            Revendedores atualizada = revendedoresService.atualizar(id, revendedorAtualizado);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar revendedor", description = "Remove um revendedor do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        revendedoresService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}