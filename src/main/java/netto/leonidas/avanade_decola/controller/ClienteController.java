package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.Cliente;
import netto.leonidas.avanade_decola.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarTodosClientes() {
        return clienteService.listarTodosClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable int id) {
        return clienteService.buscarClientePorId(id);
    }

    @GetMapping("/{cpf}")
    public Cliente buscarClientePorCpf(@PathVariable BigInteger cpf) {
        return clienteService.buscarClientePorCpf(cpf);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable int id) {
        clienteService.deletarCliente(id);
    }

    @GetMapping("/buscar")
    public List<Cliente> buscarClientesPorNome(@RequestParam String nome) {
        return clienteService.buscarClientesPorNome(nome);
    }

    @GetMapping("/email/{email}")
    public Cliente buscarClientePorEmail(@PathVariable String email) {
        return clienteService.buscarClientePorEmail(email);
    }
}
