package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.ItemVenda;
import netto.leonidas.avanade_decola.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/itens-venda")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @PostMapping
    public ItemVenda salvarItemVenda(@RequestBody ItemVenda itemVenda) {
        return itemVendaService.salvarItemVenda(itemVenda);
    }

    @GetMapping
    public List<ItemVenda> listarTodosItensVenda() {
        return itemVendaService.listarTodosItensVenda();
    }

    @DeleteMapping
    public void deletarItemVenda(@RequestBody ItemVenda.ItemVendaId id) {
        itemVendaService.deletarItemVenda(id);
    }

    @GetMapping("/venda/{idVenda}")
    public List<ItemVenda> buscarItensVendaPorVenda(@PathVariable int idVenda) {
        return itemVendaService.buscarItensVendaPorVenda(idVenda);
    }

    @GetMapping("/produto/{idProduto}")
    public List<ItemVenda> buscarItensVendaPorProduto(@PathVariable int idProduto) {
        return itemVendaService.buscarItensVendaPorProduto(idProduto);
    }
}