package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.Transportadora;
import netto.leonidas.avanade_decola.service.TransportadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transportadoras")
public class TransportadoraController {

    @Autowired
    private TransportadoraService transportadoraService;

    @PostMapping
    public Transportadora salvarTransportadora(@RequestBody Transportadora transportadora) {
        return transportadoraService.salvarTransportadora(transportadora);
    }

    @GetMapping
    public List<Transportadora> listarTodasTransportadoras() {
        return transportadoraService.listarTodasTransportadoras();
    }

    @GetMapping("/{id}")
    public Transportadora buscarTransportadoraPorId(@PathVariable int id) {
        return transportadoraService.buscarTransportadoraPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarTransportadora(@PathVariable int id) {
        transportadoraService.deletarTransportadora(id);
    }

    @GetMapping("/buscar")
    public List<Transportadora> buscarTransportadorasPorRazaoSocial(@RequestParam String razaoSocial) {
        return transportadoraService.buscarTransportadorasPorRazaoSocial(razaoSocial);
    }

    @GetMapping("/cnpj/{cnpj}")
    public Transportadora buscarTransportadoraPorCnpj(@PathVariable String cnpj) {
        return transportadoraService.buscarTransportadoraPorCnpj(cnpj);
    }
}
