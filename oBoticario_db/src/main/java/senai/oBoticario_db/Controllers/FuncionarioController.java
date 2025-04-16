package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Funcionario;
import senai.oBoticario_db.service.FuncionarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
@Tag(name = "Funcionários", description = "Operações relacionadas a funcionários")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    @Operation(summary = "Listar todos os funcionários", description = "Retorna uma lista de todos os funcionários cadastrados.")
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar funcionário por ID", description = "Retorna as informações de um funcionário com base no ID fornecido.")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable long id) {
        Optional<Funcionario> funcionario = funcionarioService.buscarPorId(id);
        return funcionario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo funcionário", description = "Cadastra um novo funcionário com as informações fornecidas.")
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvar(funcionario);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar funcionário", description = "Atualiza as informações de um funcionário existente com base no ID fornecido.")
    public ResponseEntity<Funcionario> atualizar(@PathVariable long id, @RequestBody Funcionario funcionario) {
        try {
            Funcionario atualizado = funcionarioService.atualizar(id, funcionario);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar funcionário", description = "Remove um funcionário do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}