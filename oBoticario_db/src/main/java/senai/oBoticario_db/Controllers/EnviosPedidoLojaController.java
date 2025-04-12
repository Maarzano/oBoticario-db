package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.EnviosPedidoLoja;
import senai.oBoticario_db.service.EnviosPedidoLojaService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/envio_pedido_loja")
public class EnviosPedidoLojaController {
    
    @Autowired
    private EnviosPedidoLojaService enviosPedidoLojaService;

    @GetMapping
    public List<EnviosPedidoLoja> listarTodos() {
        return enviosPedidoLojaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnviosPedidoLoja> buscarPorId(@PathVariable long id) {
        Optional<EnviosPedidoLoja> EnviosPedidoLojas = enviosPedidoLojaService.buscarPorId(id);
        return EnviosPedidoLojas.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EnviosPedidoLoja> criar(@RequestBody EnviosPedidoLoja novoeEnviosPedidoLoja) {
        EnviosPedidoLoja enviosPedidoLojaSalva = enviosPedidoLojaService.salvar(novoeEnviosPedidoLoja);
        return ResponseEntity.ok(enviosPedidoLojaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnviosPedidoLoja> atualizar(@PathVariable long id, @RequestBody EnviosPedidoLoja enviosPedidoLojaAtualizada) {
        try {
            EnviosPedidoLoja atualizada = enviosPedidoLojaService.atualizar(id, enviosPedidoLojaAtualizada);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        enviosPedidoLojaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
