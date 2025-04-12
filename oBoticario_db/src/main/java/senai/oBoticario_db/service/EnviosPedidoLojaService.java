package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.oBoticario_db.Repository.EnviosPedidoLojaRepository;
import senai.oBoticario_db.model.*;

import java.util.List;
import java.util.Optional;

@Service
public class EnviosPedidoLojaService {
    
    @Autowired
    private EnviosPedidoLojaRepository enviosPedidoLojaRepository;

    public List<EnviosPedidoLoja> listarTodos() {
        return enviosPedidoLojaRepository.findAll();
    }

    public Optional<EnviosPedidoLoja> buscarPorId(long id) {
        return enviosPedidoLojaRepository.findById(id);
    }

    public EnviosPedidoLoja salvar(EnviosPedidoLoja EnviosPedidoLojas) {
        return enviosPedidoLojaRepository.save(EnviosPedidoLojas);
    }

    public EnviosPedidoLoja atualizar(long id, EnviosPedidoLoja EnviosPedidoLojaAtualizada) {
        return enviosPedidoLojaRepository.findById(id).map(EnviosPedidoLojas -> {
            EnviosPedidoLojas.setDistribuidora(EnviosPedidoLojaAtualizada.getDistribuidora());
            EnviosPedidoLojas.setNumeroRemessa(EnviosPedidoLojaAtualizada.getNumeroRemessa());
            EnviosPedidoLojas.setDataEnvioRemessa(EnviosPedidoLojaAtualizada.getDataEnvioRemessa());
            EnviosPedidoLojas.setRotasLojas(EnviosPedidoLojaAtualizada.getRotasLojas());
            return enviosPedidoLojaRepository.save(EnviosPedidoLojas);
        }).orElseThrow(() -> new RuntimeException("venda não encontrado!"));
    }

    public void deletar(long id) {
        enviosPedidoLojaRepository.deleteById(id);
    }
}
