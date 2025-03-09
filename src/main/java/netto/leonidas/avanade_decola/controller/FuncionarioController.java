package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.Funcionario;
import netto.leonidas.avanade_decola.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvarFuncionario(funcionario);
    }

    @GetMapping
    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioService.listarTodosFuncionarios();
    }

    @GetMapping("/{id}")
    public Funcionario buscarFuncionarioPorId(@PathVariable int id) {
        return funcionarioService.buscarFuncionarioPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable int id) {
        funcionarioService.deletarFuncionario(id);
    }

    @GetMapping("/buscar")
    public List<Funcionario> buscarFuncionariosPorNome(@RequestParam String nome) {
        return funcionarioService.buscarFuncionariosPorNome(nome);
    }

    @GetMapping("/cpf/{cpf}")
    public Funcionario buscarFuncionarioPorCpf(@PathVariable String cpf) {
        return funcionarioService.buscarFuncionarioPorCpf(cpf);
    }

    @GetMapping("/cargo/{idCargo}")
    public List<Funcionario> buscarFuncionariosPorCargo(@PathVariable int idCargo) {
        return funcionarioService.buscarFuncionariosPorCargo(idCargo);
    }
}
