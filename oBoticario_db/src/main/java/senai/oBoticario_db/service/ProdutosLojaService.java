package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.oBoticario_db.model.ProdutosLoja;
import senai.oBoticario_db.repository.ProdutosLojaRepository;

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
            produto.setProdutoID_Distr(produtoAtualizado.getProdutoID_Distr());
            produto.setLojaID(produtoAtualizado.getLojaID());
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPrecoProduto(produtoAtualizado.getPrecoProduto());
            produto.setQuantidade_Produto_Loja(produtoAtualizado.getQuantidade_Produto_Loja());
            produto.setCategoriaID(produtoAtualizado.getCategoriaID());
            produto.setQuantidade_Vendidos_Loja(produtoAtualizado.getQuantidade_Vendidos_Loja());
            return produtosLojaRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto na loja não encontrado!"));
    }

    public void deletar(long id) {
        produtosLojaRepository.deleteById(id);
    }
}

