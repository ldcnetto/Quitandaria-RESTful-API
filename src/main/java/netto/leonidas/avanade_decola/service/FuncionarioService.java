package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.Funcionario;
import java.util.List;

public interface FuncionarioService {
    Funcionario salvarFuncionario(Funcionario funcionario);
    List<Funcionario> listarTodosFuncionarios();
    Funcionario buscarFuncionarioPorId(int id);
    void deletarFuncionario(int id);
    List<Funcionario> buscarFuncionariosPorNome(String nome);
    Funcionario buscarFuncionarioPorCpf(String cpf);
    List<Funcionario> buscarFuncionariosPorCargo(int idCargo);
}