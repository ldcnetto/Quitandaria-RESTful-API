package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.ProdutoFornecedor;

import java.util.List;

public interface ProdutoFornecedorService {
    ProdutoFornecedor salvarProdutoFornecedor(ProdutoFornecedor produtoFornecedor);
    List<ProdutoFornecedor> listarTodosProdutosFornecedores();
    void deletarProdutoFornecedor(ProdutoFornecedor.ProdutoFornecedorId id);
    List<ProdutoFornecedor> buscarProdutosPorFornecedor(int idFornecedor);
    List<ProdutoFornecedor> buscarFornecedoresPorProduto(int idProduto);
}
