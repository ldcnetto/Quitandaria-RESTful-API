package netto.leonidas.avanade_decola.controller;

import netto.leonidas.avanade_decola.model.Cargo;
import netto.leonidas.avanade_decola.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @PostMapping
    public Cargo salvarCargo(@RequestBody Cargo cargo) {
        return cargoService.salvarCargo(cargo);
    }

    @GetMapping
    public List<Cargo> listarTodosCargos() {
        return cargoService.listarTodosCargos();
    }

    @GetMapping("/{id}")
    public Cargo buscarCargoPorId(@PathVariable int id) {
        return cargoService.buscarCargoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCargo(@PathVariable int id) {
        cargoService.deletarCargo(id);
    }

    @GetMapping("/buscar")
    public List<Cargo> buscarCargosPorDescricao(@RequestParam String descricao) {
        return cargoService.buscarCargosPorDescricao(descricao);
    }
}
