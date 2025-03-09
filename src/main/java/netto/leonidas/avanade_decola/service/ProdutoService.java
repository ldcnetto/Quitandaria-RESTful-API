package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.Produto;
import java.math.BigDecimal;
import java.util.List;

public interface ProdutoService {
    Produto salvarProduto(Produto produto);
    List<Produto> listarTodosProdutos();
    Produto buscarProdutoPorId(int id);
    void deletarProduto(int id);
    List<Produto> buscarProdutosPorDescricao(String descricao);
    List<Produto> buscarProdutosPorPreco(BigDecimal precoInicial, BigDecimal precoFinal);
}
