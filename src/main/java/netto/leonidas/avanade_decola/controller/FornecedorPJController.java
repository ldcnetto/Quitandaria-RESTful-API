package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.FornecedorPJ;
import netto.leonidas.avanade_decola.service.FornecedorPJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedores-pj")
public class FornecedorPJController {

    @Autowired
    private FornecedorPJService fornecedorPJService;

    @PostMapping
    public FornecedorPJ salvarFornecedorPJ(@RequestBody FornecedorPJ fornecedorPJ) {
        return fornecedorPJService.salvarFornecedorPJ(fornecedorPJ);
    }

    @GetMapping("/{cnpj}")
    public FornecedorPJ buscarFornecedorPJPorCnpj(@PathVariable String cnpj) {
        return fornecedorPJService.buscarFornecedorPJPorCnpj(cnpj);
    }

    @DeleteMapping("/{cnpj}")
    public void deletarFornecedorPJ(@PathVariable String cnpj) {
        fornecedorPJService.deletarFornecedorPJ(cnpj);
    }
}