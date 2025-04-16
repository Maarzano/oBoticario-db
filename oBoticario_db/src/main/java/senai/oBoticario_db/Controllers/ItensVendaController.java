package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.oBoticario_db.model.ItensVenda;
import senai.oBoticario_db.service.ItensVendaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens-venda")
@Tag(name = "Itens de Venda", description = "Operações relacionadas aos itens de venda")
public class ItensVendaController {

    @Autowired
    private ItensVendaService itemVendaService;

    @PostMapping
    @Operation(summary = "Criar um novo item de venda", description = "Cadastra um novo item de venda com as informações fornecidas.")
    public ResponseEntity<ItensVenda> criarItemVenda(@RequestBody ItensVenda itemVenda) {
        ItensVenda itemVendaCriado = itemVendaService.salvar(itemVenda);
        return new ResponseEntity<>(itemVendaCriado, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Obter todos os itens de venda", description = "Retorna uma lista de todos os itens de venda cadastrados.")
    public List<ItensVenda> obterTodosItensVenda() {
        return itemVendaService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter item de venda por ID", description = "Retorna as informações de um item de venda com base no ID fornecido.")
    public ResponseEntity<ItensVenda> obterItemVendaPorId(@PathVariable long id) {  
        Optional<ItensVenda> itemVenda = itemVendaService.buscarPorId(id);  
        return itemVenda.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de venda", description = "Atualiza as informações de um item de venda existente com base no ID fornecido.")
    public ResponseEntity<ItensVenda> atualizarItemVenda(@PathVariable long id, @RequestBody ItensVenda itemVenda) {  
        try {
            ItensVenda itemVendaAtualizado = itemVendaService.atualizar(id, itemVenda);  
            return ResponseEntity.ok(itemVendaAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar item de venda", description = "Remove um item de venda do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletarItemVenda(@PathVariable long id) {  
        try {
            itemVendaService.deletar(id); 
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}