package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.FormaPagamento;
import netto.leonidas.avanade_decola.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @PostMapping
    public FormaPagamento salvarFormaPagamento(@RequestBody FormaPagamento formaPagamento) {
        return formaPagamentoService.salvarFormaPagamento(formaPagamento);
    }

    @GetMapping
    public List<FormaPagamento> listarTodasFormasPagamento() {
        return formaPagamentoService.listarTodasFormasPagamento();
    }

    @GetMapping("/{id}")
    public FormaPagamento buscarFormaPagamentoPorId(@PathVariable int id) {
        return formaPagamentoService.buscarFormaPagamentoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarFormaPagamento(@PathVariable int id) {
        formaPagamentoService.deletarFormaPagamento(id);
    }

    @GetMapping("/buscar")
    public List<FormaPagamento> buscarFormasPagamentoPorDescricao(@RequestParam String descricao) {
        return formaPagamentoService.buscarFormasPagamentoPorDescricao(descricao);
    }
}