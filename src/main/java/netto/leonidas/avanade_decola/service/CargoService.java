package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.Cargo;
import java.util.List;

public interface CargoService {
    Cargo salvarCargo(Cargo cargo);
    List<Cargo> listarTodosCargos();
    Cargo buscarCargoPorId(int id);
    void deletarCargo(int id);
    List<Cargo> buscarCargosPorDescricao(String descricao);
}
