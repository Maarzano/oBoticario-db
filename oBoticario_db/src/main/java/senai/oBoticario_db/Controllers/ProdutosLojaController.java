package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.oBoticario_db.model.ProdutosLoja;
import senai.oBoticario_db.service.ProdutosLojaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtosloja")
@Tag(name = "Produtos da Loja", description = "Operações relacionadas aos produtos disponíveis nas lojas")
public class ProdutosLojaController {

    @Autowired
    private ProdutosLojaService produtosLojaService;

    @GetMapping
    @Operation(summary = "Listar todos os produtos da loja", description = "Retorna uma lista de todos os produtos disponíveis nas lojas.")
    public List<ProdutosLoja> listarTodos() {
        return produtosLojaService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto da loja por ID", description = "Retorna as informações de um produto da loja com base no ID fornecido.")
    public ResponseEntity<ProdutosLoja> buscarPorId(@PathVariable long id) {
        Optional<ProdutosLoja> produto = produtosLojaService.buscarPorId(id);
        return produto.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo produto da loja", description = "Cadastra um novo produto da loja com as informações fornecidas.")
    public ResponseEntity<ProdutosLoja> criar(@RequestBody ProdutosLoja novoProduto) {
        ProdutosLoja salvo = produtosLojaService.salvar(novoProduto);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar produto da loja", description = "Atualiza as informações de um produto da loja existente com base no ID fornecido.")
    public ResponseEntity<ProdutosLoja> atualizar(@PathVariable long id, @RequestBody ProdutosLoja produtoAtualizado) {
        try {
            ProdutosLoja atualizado = produtosLojaService.atualizar(id, produtoAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar produto da loja", description = "Remove um produto da loja do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        produtosLojaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}