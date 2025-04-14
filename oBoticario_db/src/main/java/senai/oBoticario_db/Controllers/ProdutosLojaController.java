package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.oBoticario_db.model.ProdutosLoja;
import senai.oBoticario_db.service.ProdutosLojaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtosloja")
public class ProdutosLojaController {

    @Autowired
    private ProdutosLojaService produtosLojaService;

    @GetMapping
    public List<ProdutosLoja> listarTodos() {
        return produtosLojaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosLoja> buscarPorId(@PathVariable long id) {
        Optional<ProdutosLoja> produto = produtosLojaService.buscarPorId(id);
        return produto.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProdutosLoja> criar(@RequestBody ProdutosLoja novoProduto) {
        ProdutosLoja salvo = produtosLojaService.salvar(novoProduto);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosLoja> atualizar(@PathVariable long id, @RequestBody ProdutosLoja produtoAtualizado) {
        try {
            ProdutosLoja atualizado = produtosLojaService.atualizar(id, produtoAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        produtosLojaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}