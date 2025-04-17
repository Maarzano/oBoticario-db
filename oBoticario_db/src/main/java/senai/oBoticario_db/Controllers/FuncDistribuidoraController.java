package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.FuncDistribuidora;
import senai.oBoticario_db.service.FuncDistribuidoraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios_Distribuidora")
@Tag(name = "Funcionários da Distribuidora", description = "Operações relacionadas aos funcionários da distribuidora")
public class FuncDistribuidoraController {

    @Autowired
    private FuncDistribuidoraService funcDistribuidoraService;

    @GetMapping
    @Operation(summary = "Listar todos os funcionários da distribuidora", description = "Retorna uma lista de todos os funcionários da distribuidora cadastrados.")
    public List<FuncDistribuidora> listarTodos() {
        return funcDistribuidoraService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar funcionário da distribuidora por ID", description = "Retorna as informações de um funcionário da distribuidora com base no ID fornecido.")
    public ResponseEntity<FuncDistribuidora> buscarPorId(@PathVariable long id) {
        Optional<FuncDistribuidora> funcionario = funcDistribuidoraService.buscarPorId(id);
        return funcionario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo funcionário da distribuidora", description = "Cadastra um novo funcionário da distribuidora com as informações fornecidas.")
    public ResponseEntity<FuncDistribuidora> criar(@RequestBody FuncDistribuidora novoFuncionario) {
        FuncDistribuidora funcionarioSalvo = funcDistribuidoraService.salvar(novoFuncionario);
        return ResponseEntity.ok(funcionarioSalvo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar funcionário da distribuidora", description = "Atualiza as informações de um funcionário da distribuidora existente com base no ID fornecido.")
    public ResponseEntity<FuncDistribuidora> atualizar(@PathVariable long id, @RequestBody FuncDistribuidora funcionarioAtualizado) {
        try {
            FuncDistribuidora atualizado = funcDistribuidoraService.atualizar(id, funcionarioAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar funcionário da distribuidora", description = "Remove um funcionário da distribuidora do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        funcDistribuidoraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}