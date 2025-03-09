package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.Venda;
import netto.leonidas.avanade_decola.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public Venda salvarVenda(@RequestBody Venda venda) {
        return vendaService.salvarVenda(venda);
    }

    @GetMapping
    public List<Venda> listarTodasVendas() {
        return vendaService.listarTodasVendas();
    }

    @GetMapping("/{id}")
    public Venda buscarVendaPorId(@PathVariable int id) {
        return vendaService.buscarVendaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarVenda(@PathVariable int id) {
        vendaService.deletarVenda(id);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Venda> buscarVendasPorCliente(@PathVariable int idCliente) {
        return vendaService.buscarVendasPorCliente(idCliente);
    }

    @GetMapping("/funcionario/{idFuncionario}")
    public List<Venda> buscarVendasPorFuncionario(@PathVariable int idFuncionario) {
        return vendaService.buscarVendasPorFuncionario(idFuncionario);
    }

    @GetMapping("/periodo")
    public List<Venda> buscarVendasPorPeriodo(
            @RequestParam LocalDateTime inicio,
            @RequestParam LocalDateTime fim) {
        return vendaService.buscarVendasPorPeriodo(inicio, fim);
    }
}
