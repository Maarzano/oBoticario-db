package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Ferias;
import senai.oBoticario_db.service.FeriasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ferias")
@Tag(name = "Férias", description = "Operações relacionadas às férias dos funcionários")
public class FeriasController {

    @Autowired
    private FeriasService feriasService;

    @GetMapping
    @Operation(summary = "Listar todas as férias", description = "Retorna uma lista de todas as férias cadastradas.")
    public List<Ferias> listarTodos() {
        return feriasService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar férias por ID", description = "Retorna as informações de férias com base no ID fornecido.")
    public ResponseEntity<Ferias> buscarPorId(@PathVariable long id) {
        Optional<Ferias> ferias = feriasService.buscarPorId(id);
        return ferias.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar novas férias", description = "Cadastra novas férias com as informações fornecidas.")
    public ResponseEntity<Ferias> criar(@RequestBody Ferias novasFerias) {
        Ferias feriasSalvas = feriasService.salvar(novasFerias);
        return ResponseEntity.ok(feriasSalvas);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar férias", description = "Atualiza as informações de férias existentes com base no ID fornecido.")
    public ResponseEntity<Ferias> atualizar(@PathVariable long id, @RequestBody Ferias feriasAtualizadas) {
        try {
            Ferias atualizado = feriasService.atualizar(id, feriasAtualizadas);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar férias", description = "Remove férias do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        feriasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}