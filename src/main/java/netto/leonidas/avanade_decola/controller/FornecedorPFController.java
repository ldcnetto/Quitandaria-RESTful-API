package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.FornecedorPF;
import netto.leonidas.avanade_decola.service.FornecedorPFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedores-pf")
public class FornecedorPFController {

    @Autowired
    private FornecedorPFService fornecedorPFService;

    @PostMapping
    public FornecedorPF salvarFornecedorPF(@RequestBody FornecedorPF fornecedorPF) {
        return fornecedorPFService.salvarFornecedorPF(fornecedorPF);
    }

    @GetMapping("/{cpf}")
    public FornecedorPF buscarFornecedorPFPorCpf(@PathVariable String cpf) {
        return fornecedorPFService.buscarFornecedorPFPorCpf(cpf);
    }

    @DeleteMapping("/{cpf}")
    public void deletarFornecedorPF(@PathVariable String cpf) {
        fornecedorPFService.deletarFornecedorPF(cpf);
    }
}
