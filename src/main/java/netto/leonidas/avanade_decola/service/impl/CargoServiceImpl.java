package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.Cargo;
import netto.leonidas.avanade_decola.repository.CargoRepository;
import netto.leonidas.avanade_decola.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Cargo salvarCargo(Cargo cargo) {
        // Validação: Verifica se a descrição do cargo está vazia ou nula
        if (cargo.getDescricao() == null || cargo.getDescricao().trim().isEmpty()) {
            throw new ValidationException("A descrição do cargo não pode ser vazia.");
        }

        return cargoRepository.save(cargo);
    }

    @Override
    public List<Cargo> listarTodosCargos() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo buscarCargoPorId(int id) {
        return cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo não encontrado com o ID: " + id));
    }

    @Override
    public void deletarCargo(int id) {
        // Verifica se o cargo existe antes de tentar deletar
        if (!cargoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cargo não encontrado com o ID: " + id);
        }
        cargoRepository.deleteById(id);
    }

    @Override
    public List<Cargo> buscarCargosPorDescricao(String descricao) {
        // Validação: Verifica se a descrição está vazia ou nula
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new ValidationException("A descrição não pode ser vazia.");
        }

        return cargoRepository.findByDescricaoContaining(descricao);
    }
}