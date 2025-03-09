package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.Estoque;
import netto.leonidas.avanade_decola.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    public Estoque salvarEstoque(@RequestBody Estoque estoque) {
        return estoqueService.salvarEstoque(estoque);
    }

    @GetMapping
    public List<Estoque> listarTodosEstoques() {
        return estoqueService.listarTodosEstoques();
    }

    @GetMapping("/produto/{idProduto}")
    public Estoque buscarEstoquePorProduto(@PathVariable int idProduto) {
        return estoqueService.buscarEstoquePorProduto(idProduto);
    }

    @DeleteMapping("/produto/{idProduto}")
    public void deletarEstoque(@PathVariable int idProduto) {
        estoqueService.deletarEstoque(idProduto);
    }

    @GetMapping("/quantidade/{quantidade}")
    public List<Estoque> buscarEstoquesComQuantidadeAbaixoDe(@PathVariable int quantidade) {
        return estoqueService.buscarEstoquesComQuantidadeAbaixoDe(quantidade);
    }
}
