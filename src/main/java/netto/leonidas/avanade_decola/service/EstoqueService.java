package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.Estoque;
import java.util.List;

public interface EstoqueService {
    Estoque salvarEstoque(Estoque estoque);
    List<Estoque> listarTodosEstoques();
    Estoque buscarEstoquePorProduto(int idProduto);
    void deletarEstoque(int idProduto);
    List<Estoque> buscarEstoquesComQuantidadeAbaixoDe(int quantidade);
}
