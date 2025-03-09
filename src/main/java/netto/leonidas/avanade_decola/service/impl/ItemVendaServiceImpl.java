package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.ItemVenda;
import netto.leonidas.avanade_decola.repository.ItemVendaRepository;
import netto.leonidas.avanade_decola.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemVendaServiceImpl implements ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Override
    public ItemVenda salvarItemVenda(ItemVenda itemVenda) {
        return itemVendaRepository.save(itemVenda);
    }

    @Override
    public List<ItemVenda> listarTodosItensVenda() {
        return itemVendaRepository.findAll();
    }

    @Override
    public void deletarItemVenda(ItemVenda.ItemVendaId id) {
        if (!itemVendaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Item de venda não encontrado com o ID: " + id);
        }
        itemVendaRepository.deleteById(id);
    }

    @Override
    public List<ItemVenda> buscarItensVendaPorVenda(int idVenda) {
        return itemVendaRepository.findByVendaId(idVenda);
    }

    @Override
    public List<ItemVenda> buscarItensVendaPorProduto(int idProduto) {
        return itemVendaRepository.findByProdutoId(idProduto);
    }
}