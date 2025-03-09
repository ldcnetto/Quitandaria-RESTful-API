package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.ProdutoFornecedor;
import netto.leonidas.avanade_decola.service.ProdutoFornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos-fornecedores")
public class ProdutoFornecedorController {

    @Autowired
    private ProdutoFornecedorService produtoFornecedorService;

    @PostMapping
    public ProdutoFornecedor salvarProdutoFornecedor(@RequestBody ProdutoFornecedor produtoFornecedor) {
        return produtoFornecedorService.salvarProdutoFornecedor(produtoFornecedor);
    }

    @GetMapping
    public List<ProdutoFornecedor> listarTodosProdutosFornecedores() {
        return produtoFornecedorService.listarTodosProdutosFornecedores();
    }

    @DeleteMapping
    public void deletarProdutoFornecedor(@RequestBody ProdutoFornecedor.ProdutoFornecedorId id) {
        produtoFornecedorService.deletarProdutoFornecedor(id);
    }

    @GetMapping("/fornecedor/{idFornecedor}")
    public List<ProdutoFornecedor> buscarProdutosPorFornecedor(@PathVariable int idFornecedor) {
        return produtoFornecedorService.buscarProdutosPorFornecedor(idFornecedor);
    }

    @GetMapping("/produto/{idProduto}")
    public List<ProdutoFornecedor> buscarFornecedoresPorProduto(@PathVariable int idProduto) {
        return produtoFornecedorService.buscarFornecedoresPorProduto(idProduto);
    }
}
