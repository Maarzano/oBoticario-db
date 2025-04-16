package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.EnviosPedidoLoja;
import senai.oBoticario_db.service.EnviosPedidoLojaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/envio_pedido_loja")
@Tag(name = "Envios de Pedido Loja", description = "Operações relacionadas aos envios de pedidos para loja")
public class EnviosPedidoLojaController {
    
    @Autowired
    private EnviosPedidoLojaService enviosPedidoLojaService;

    @GetMapping
    @Operation(summary = "Listar todos os envios de pedido loja", description = "Retorna uma lista de todos os envios de pedidos para loja cadastrados.")
    public List<EnviosPedidoLoja> listarTodos() {
        return enviosPedidoLojaService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar envio de pedido loja por ID", description = "Retorna as informações de um envio de pedido para loja com base no ID fornecido.")
    public ResponseEntity<EnviosPedidoLoja> buscarPorId(@PathVariable long id) {
        Optional<EnviosPedidoLoja> enviosPedidoLojas = enviosPedidoLojaService.buscarPorId(id);
        return enviosPedidoLojas.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo envio de pedido loja", description = "Cadastra um novo envio de pedido para loja com as informações fornecidas.")
    public ResponseEntity<EnviosPedidoLoja> criar(@RequestBody EnviosPedidoLoja novoeEnviosPedidoLoja) {
        EnviosPedidoLoja enviosPedidoLojaSalva = enviosPedidoLojaService.salvar(novoeEnviosPedidoLoja);
        return ResponseEntity.ok(enviosPedidoLojaSalva);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar envio de pedido loja", description = "Atualiza as informações de um envio de pedido para loja existente com base no ID fornecido.")
    public ResponseEntity<EnviosPedidoLoja> atualizar(@PathVariable long id, @RequestBody EnviosPedidoLoja enviosPedidoLojaAtualizada) {
        try {
            EnviosPedidoLoja atualizada = enviosPedidoLojaService.atualizar(id, enviosPedidoLojaAtualizada);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar envio de pedido loja", description = "Remove um envio de pedido para loja do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        enviosPedidoLojaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}