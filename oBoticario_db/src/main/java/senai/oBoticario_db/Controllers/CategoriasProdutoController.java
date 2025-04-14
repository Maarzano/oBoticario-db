package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.oBoticario_db.model.CategoriasProduto;
import senai.oBoticario_db.service.CategoriasProdutoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriasProdutoController {

    @Autowired
    private CategoriasProdutoService categoriasProdutoService;

    @GetMapping
    public List<CategoriasProduto> listarTodos() {
        return categoriasProdutoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriasProduto> buscarPorId(@PathVariable long id) {
        Optional<CategoriasProduto> categoria = categoriasProdutoService.buscarPorId(id);
        return categoria.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoriasProduto> criar(@RequestBody CategoriasProduto novaCategoria) {
        CategoriasProduto salva = categoriasProdutoService.salvar(novaCategoria);
        return ResponseEntity.ok(salva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriasProduto> atualizar(@PathVariable long id, @RequestBody CategoriasProduto atualizada) {
        try {
            CategoriasProduto categoriaAtualizada = categoriasProdutoService.atualizar(id, atualizada);
            return ResponseEntity.ok(categoriaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        categoriasProdutoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
