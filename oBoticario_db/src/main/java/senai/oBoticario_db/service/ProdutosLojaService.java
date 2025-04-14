package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.oBoticario_db.Repository.ProdutosLojaRepository;
import senai.oBoticario_db.model.ProdutosLoja;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosLojaService {

    @Autowired
    private ProdutosLojaRepository produtosLojaRepository;

    public List<ProdutosLoja> listarTodos() {
        return produtosLojaRepository.findAll();
    }

    public Optional<ProdutosLoja> buscarPorId(long id) {
        return produtosLojaRepository.findById(id);
    }

    public ProdutosLoja salvar(ProdutosLoja produto) {
        return produtosLojaRepository.save(produto);
    }

    public ProdutosLoja atualizar(long id, ProdutosLoja produtoAtualizado) {
        return produtosLojaRepository.findById(id).map(produto -> {
            produto.setProdutoDistribuidora(produtoAtualizado.getProdutoDistribuidora());
            produto.setLojaID(produtoAtualizado.getLojaID());
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPrecoProduto(produtoAtualizado.getPrecoProduto());
            produto.setQuantidadeProdutoLoja(produtoAtualizado.getQuantidadeProdutoLoja());
            produto.setCategoria(produtoAtualizado.getCategoria());
            produto.setQuantidadeVendidosLoja(produtoAtualizado.getQuantidadeVendidosLoja());
            return produtosLojaRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto na loja não encontrado!"));
    }

    public void deletar(long id) {
        produtosLojaRepository.deleteById(id);
    }
}

