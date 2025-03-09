package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.Produto;
import netto.leonidas.avanade_decola.repository.ProdutoRepository;
import netto.leonidas.avanade_decola.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto salvarProduto(Produto produto) {
        if (produto.getDescricao() == null || produto.getDescricao().trim().isEmpty()) {
            throw new ValidationException("A descrição do produto não pode ser vazia.");
        }

        if (produto.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("O preço do produto não pode ser menor ou igual a zero.");
        }

        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarProdutoPorId(int id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + id));
    }

    @Override
    public void deletarProduto(int id) {
        if (!produtoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado com o ID: " + id);
        }
        produtoRepository.deleteById(id);
    }

    @Override
    public List<Produto> buscarProdutosPorDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new ValidationException("A descrição não pode ser vazia.");
        }

        return produtoRepository.findByDescricaoContaining(descricao);
    }

    @Override
    public List<Produto> buscarProdutosPorPreco(BigDecimal precoInicial, BigDecimal precoFinal) {
        if (precoInicial.compareTo(BigDecimal.ZERO) < 0 || precoFinal.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Os preços não podem ser negativos.");
        }

        return produtoRepository.findByPrecoBetween(precoInicial, precoFinal);
    }
}