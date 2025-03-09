package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.Produto;
import netto.leonidas.avanade_decola.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @GetMapping
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable int id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable int id) {
        produtoService.deletarProduto(id);
    }

    @GetMapping("/buscar")
    public List<Produto> buscarProdutosPorDescricao(@RequestParam String descricao) {
        return produtoService.buscarProdutosPorDescricao(descricao);
    }

    @GetMapping("/preco")
    public List<Produto> buscarProdutosPorPreco(
            @RequestParam BigDecimal precoInicial,
            @RequestParam BigDecimal precoFinal) {
        return produtoService.buscarProdutosPorPreco(precoInicial, precoFinal);
    }
}
