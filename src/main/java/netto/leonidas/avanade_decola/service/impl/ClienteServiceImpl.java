package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ConflictException;
import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.Cliente;
import netto.leonidas.avanade_decola.repository.ClienteRepository;
import netto.leonidas.avanade_decola.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        // Validação: Verifica se o nome do cliente está vazio ou nulo
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new ValidationException("O nome do cliente não pode ser vazio.");
        }

        // Validação: Verifica se o email do cliente está vazio ou nulo
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            throw new ValidationException("O email do cliente não pode ser vazio.");
        }

        // Verifica se já existe um cliente com o mesmo email
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new ConflictException("Já existe um cliente com esse cpf: " + cliente.getCpf());
        }

        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClientePorId(int id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));
    }

    @Override
    public void deletarCliente(int id) {
        // Verifica se o cliente existe antes de tentar deletar
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado com o ID: " + id);
        }
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> buscarClientesPorNome(String nome) {
        // Validação: Verifica se o nome está vazio ou nulo
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidationException("O nome não pode ser vazio.");
        }

        return clienteRepository.findByNomeContaining(nome);
    }

    @Override
    public Cliente buscarClientePorEmail(String email) {
        // Validação: Verifica se o email está vazio ou nulo
        if (email == null || email.trim().isEmpty()) {
            throw new ValidationException("O email não pode ser vazio.");
        }

        return clienteRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o email: " + email));
    }

    @Override
    public Cliente buscarClientePorCpf(BigInteger cpf) {
        // Validação: Verifica se o nome está vazio ou nulo
        if (cpf.compareTo(BigInteger.ZERO) == 0) {
            throw new ValidationException("O cpf não pode ser vazio.");
        }

        return (Cliente) clienteRepository.findByCpfContaining(String.valueOf(cpf));
    }
}