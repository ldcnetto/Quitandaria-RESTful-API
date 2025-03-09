package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.Fornecedor;
import netto.leonidas.avanade_decola.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public Fornecedor salvarFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.salvarFornecedor(fornecedor);
    }

    @GetMapping
    public List<Fornecedor> listarTodosFornecedores() {
        return fornecedorService.listarTodosFornecedores();
    }

    @GetMapping("/{id}")
    public Fornecedor buscarFornecedorPorId(@PathVariable int id) {
        return fornecedorService.buscarFornecedorPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarFornecedor(@PathVariable int id) {
        fornecedorService.deletarFornecedor(id);
    }

    @GetMapping("/buscar")
    public List<Fornecedor> buscarFornecedoresPorRazaoSocial(@RequestParam String razaoSocial) {
        return fornecedorService.buscarFornecedoresPorRazaoSocial(razaoSocial);
    }

    @GetMapping("/email/{email}")
    public Fornecedor buscarFornecedorPorEmail(@PathVariable String email) {
        return fornecedorService.buscarFornecedorPorEmail(email);
    }
}
