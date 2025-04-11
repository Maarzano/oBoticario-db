package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.*;
import senai.oBoticario_db.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/distribuidora")
public class DistribuidoraController {

        @Autowired
        private DistribuidoraService distribuidoraService;

        @GetMapping
        public List<Distribuidora> listarTodos() {
            return distribuidoraService.listarTodos();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Distribuidora> buscarPorId(@PathVariable long id) {
            Optional<Distribuidora> distribuidora = distribuidoraService.buscarPorId(id);
            return distribuidora.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public Distribuidora salvar(@RequestBody Distribuidora distribuidora) {
            return distribuidoraService.salvar(distribuidora);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Distribuidora> atualizar(@PathVariable long id, @RequestBody Distribuidora distribuidoraAtualizado) {
            try {
                Distribuidora distribuidora = distribuidoraService.atualizar(id, distribuidoraAtualizado);
                return ResponseEntity.ok(distribuidora);
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable long id) {
            distribuidoraService.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }