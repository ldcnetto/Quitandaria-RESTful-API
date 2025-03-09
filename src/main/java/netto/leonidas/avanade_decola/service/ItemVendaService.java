package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.ItemVenda;

import java.util.List;

public interface ItemVendaService {
    ItemVenda salvarItemVenda(ItemVenda itemVenda);
    List<ItemVenda> listarTodosItensVenda();
    void deletarItemVenda(ItemVenda.ItemVendaId id);
    List<ItemVenda> buscarItensVendaPorVenda(int idVenda);
    List<ItemVenda> buscarItensVendaPorProduto(int idProduto);
}
