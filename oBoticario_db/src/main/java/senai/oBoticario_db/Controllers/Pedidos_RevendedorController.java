package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Pedidos_Revendedor;
import senai.oBoticario_db.service.Pedidos_RevendedorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos_revendedor ")
public class Pedidos_RevendedorController {
    
    @Autowired
    private Pedidos_RevendedorService pedidos_RevendedorService;

    @GetMapping
    public List<Pedidos_Revendedor> listarTodos() {
        return pedidos_RevendedorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedidos_Revendedor> buscarPorId(@PathVariable long id) {
        Optional<Pedidos_Revendedor> Pedidos_Revendedo = pedidos_RevendedorService.buscarPorId(id);
        return Pedidos_Revendedo.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedidos_Revendedor> criar(@RequestBody Pedidos_Revendedor Pedidos_RevendedorNova) {
        Pedidos_Revendedor Pedidos_RevendedorSalva = pedidos_RevendedorService.salvar(Pedidos_RevendedorNova);
        return ResponseEntity.ok(Pedidos_RevendedorSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedidos_Revendedor> atualizar(@PathVariable long id, @RequestBody Pedidos_Revendedor pedidos_RevendedorAtualizado) {
        try {
            Pedidos_Revendedor atualizada = pedidos_RevendedorService.atualizar(id, pedidos_RevendedorAtualizado);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        pedidos_RevendedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
