package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.Endereco;
import netto.leonidas.avanade_decola.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public Endereco salvarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.salvarEndereco(endereco);
    }

    @GetMapping
    public List<Endereco> listarTodosEnderecos() {
        return enderecoService.listarTodosEnderecos();
    }

    @GetMapping("/{cep}")
    public Endereco buscarEnderecoPorCep(@PathVariable int cep) {
        return enderecoService.buscarEnderecoPorCep(cep);
    }

    @DeleteMapping("/{cep}")
    public void deletarEndereco(@PathVariable int cep) {
        enderecoService.deletarEndereco(cep);
    }

    @GetMapping("/cidade/{cidade}")
    public List<Endereco> buscarEnderecosPorCidade(@PathVariable String cidade) {
        return enderecoService.buscarEnderecosPorCidade(cidade);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Endereco> buscarEnderecosPorTipo(@PathVariable Endereco.TipoEndereco tipo) {
        return enderecoService.buscarEnderecosPorTipo(tipo);
    }
}
