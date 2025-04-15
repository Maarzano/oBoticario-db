package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.FuncDistribuidora;
import senai.oBoticario_db.service.FuncDistribuidoraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios_Distribuidora")
public class FuncDistribuidoraController {

    @Autowired
    private FuncDistribuidoraService funcDistribuidoraService;

    @GetMapping
    public List<FuncDistribuidora> listarTodos() {
        return funcDistribuidoraService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncDistribuidora> buscarPorId(@PathVariable long id) {
        Optional<FuncDistribuidora> funcionario = funcDistribuidoraService.buscarPorId(id);
        return funcionario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FuncDistribuidora> criar(@RequestBody FuncDistribuidora novoFuncionario) {
        FuncDistribuidora funcionarioSalvo = funcDistribuidoraService.salvar(novoFuncionario);
        return ResponseEntity.ok(funcionarioSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncDistribuidora> atualizar(@PathVariable long id, @RequestBody FuncDistribuidora funcionarioAtualizado) {
        try {
            FuncDistribuidora atualizado = funcDistribuidoraService.atualizar(id, funcionarioAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        funcDistribuidoraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}