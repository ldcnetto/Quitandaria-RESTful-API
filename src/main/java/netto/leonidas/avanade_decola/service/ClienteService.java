package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.Cliente;

import java.math.BigInteger;
import java.util.List;

public interface ClienteService {
    Cliente salvarCliente(Cliente cliente);
    List<Cliente> listarTodosClientes();
    Cliente buscarClientePorId(int id);
    void deletarCliente(int id);
    List<Cliente> buscarClientesPorNome(String nome);
    Cliente buscarClientePorEmail(String email);
    Cliente buscarClientePorCpf(BigInteger cpf);
}