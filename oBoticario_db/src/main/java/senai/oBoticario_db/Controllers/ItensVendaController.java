package senai.oBoticario_db.Controllers;

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
public class ItensVendaController {

    @Autowired
    private ItensVendaService itemVendaService;

    @PostMapping
    public ResponseEntity<ItensVenda> criarItemVenda(@RequestBody ItensVenda itemVenda) {
        ItensVenda itemVendaCriado = itemVendaService.salvar(itemVenda);
        return new ResponseEntity<>(itemVendaCriado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ItensVenda> obterTodosItensVenda() {
        return itemVendaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensVenda> obterItemVendaPorId(@PathVariable long id) {  
        Optional<ItensVenda> itemVenda = itemVendaService.buscarPorId(id);  
        return itemVenda.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensVenda> atualizarItemVenda(@PathVariable long id, @RequestBody ItensVenda itemVenda) {  
        try {
            ItensVenda itemVendaAtualizado = itemVendaService.atualizar(id, itemVenda);  
            return ResponseEntity.ok(itemVendaAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItemVenda(@PathVariable long id) {  
        try {
            itemVendaService.deletar(id); 
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
