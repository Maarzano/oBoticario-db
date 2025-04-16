package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.oBoticario_db.model.CategoriasProduto;
import senai.oBoticario_db.service.CategoriasProdutoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@Tag(name = "Categorias de Produto", description = "Operações relacionadas às categorias de produtos")
public class CategoriasProdutoController {

    @Autowired
    private CategoriasProdutoService categoriasProdutoService;

    @GetMapping
    @Operation(summary = "Listar todas as categorias de produtos", description = "Retorna uma lista de todas as categorias de produtos cadastradas.")
    public List<CategoriasProduto> listarTodos() {
        return categoriasProdutoService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria de produto por ID", description = "Retorna as informações de uma categoria de produto com base no ID fornecido.")
    public ResponseEntity<CategoriasProduto> buscarPorId(@PathVariable long id) {
        Optional<CategoriasProduto> categoria = categoriasProdutoService.buscarPorId(id);
        return categoria.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar uma nova categoria de produto", description = "Cadastra uma nova categoria de produto com as informações fornecidas.")
    public ResponseEntity<CategoriasProduto> criar(@RequestBody CategoriasProduto novaCategoria) {
        CategoriasProduto salva = categoriasProdutoService.salvar(novaCategoria);
        return ResponseEntity.ok(salva);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar categoria de produto", description = "Atualiza as informações de uma categoria de produto existente com base no ID fornecido.")
    public ResponseEntity<CategoriasProduto> atualizar(@PathVariable long id, @RequestBody CategoriasProduto atualizada) {
        try {
            CategoriasProduto categoriaAtualizada = categoriasProdutoService.atualizar(id, atualizada);
            return ResponseEntity.ok(categoriaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar categoria de produto", description = "Remove uma categoria de produto do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        categoriasProdutoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}