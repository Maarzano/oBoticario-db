package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Lojas;
import senai.oBoticario_db.service.LojasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lojas")
@Tag(name = "Lojas", description = "Operações relacionadas às lojas")
public class LojasController {

    @Autowired
    private LojasService lojasService;

    @GetMapping
    @Operation(summary = "Listar todas as lojas", description = "Retorna uma lista de todas as lojas cadastradas.")
    public List<Lojas> listarTodos() {
        return lojasService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar loja por ID", description = "Retorna as informações de uma loja com base no ID fornecido.")
    public ResponseEntity<Lojas> buscarPorId(@PathVariable long id) {
        Optional<Lojas> loja = lojasService.buscarPorId(id);
        return loja.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar uma nova loja", description = "Cadastra uma nova loja com as informações fornecidas.")
    public ResponseEntity<Lojas> criar(@RequestBody Lojas novaLoja) {
        Lojas lojaSalva = lojasService.salvar(novaLoja);
        return ResponseEntity.ok(lojaSalva);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar loja", description = "Atualiza as informações de uma loja existente com base no ID fornecido.")
    public ResponseEntity<Lojas> atualizar(@PathVariable long id, @RequestBody Lojas lojaAtualizada) {
        try {
            Lojas atualizada = lojasService.atualizar(id, lojaAtualizada);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar loja", description = "Remove uma loja do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        lojasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}