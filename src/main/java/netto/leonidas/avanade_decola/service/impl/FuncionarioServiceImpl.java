package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ApiException;
import netto.leonidas.avanade_decola.controller.exception.ConflictException;
import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.Funcionario;
import netto.leonidas.avanade_decola.repository.FuncionarioRepository;
import netto.leonidas.avanade_decola.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario salvarFuncionario(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().trim().isEmpty()) {
            throw new ValidationException("O nome do funcionário não pode ser vazio.");
        }

        if (funcionario.getCpf() == null || funcionario.getCpf().trim().isEmpty()) {
            throw new ValidationException("O CPF do funcionário não pode ser vazio.");
        }

        if (funcionarioRepository.existsByCpf(funcionario.getCpf())) {
            throw new ConflictException("Já existe um funcionário com o CPF: " + funcionario.getCpf());
        }

        return funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario buscarFuncionarioPorId(int id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado com o ID: " + id));
    }

    @Override
    public void deletarFuncionario(int id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Funcionário não encontrado com o ID: " + id);
        }
        funcionarioRepository.deleteById(id);
    }

    @Override
    public List<Funcionario> buscarFuncionariosPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidationException("O nome não pode ser vazio.");
        }

        return funcionarioRepository.findByNomeContaining(nome);
    }

    @Override
    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new ValidationException("O CPF não pode ser vazio.");
        }

        return funcionarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado com o CPF: " + cpf));
    }

    @Override
    public List<Funcionario> buscarFuncionariosPorCargo(int idCargo) {
        return funcionarioRepository.findByCargoId(idCargo);
    }
}