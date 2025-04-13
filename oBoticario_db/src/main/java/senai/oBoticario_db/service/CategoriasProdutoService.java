package senai.oBoticario_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.oBoticario_db.model.CategoriasProduto;
import senai.oBoticario_db.repository.CategoriasProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasProdutoService {

    @Autowired
    private CategoriasProdutoRepository categoriasProdutoRepository;

    public List<CategoriasProduto> listarTodos() {
        return categoriasProdutoRepository.findAll();
    }

    public Optional<CategoriasProduto> buscarPorId(long id) {
        return categoriasProdutoRepository.findById(id);
    }

    public CategoriasProduto salvar(CategoriasProduto categoria) {
        return categoriasProdutoRepository.save(categoria);
    }

    public CategoriasProduto atualizar(long id, CategoriasProduto categoriaAtualizada) {
        return categoriasProdutoRepository.findById(id).map(categoria -> {
            categoria.setNome(categoriaAtualizada.getNome());
            return categoriasProdutoRepository.save(categoria);
        }).orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
    }

    public void deletar(long id) {
        categoriasProdutoRepository.deleteById(id);
    }
}
