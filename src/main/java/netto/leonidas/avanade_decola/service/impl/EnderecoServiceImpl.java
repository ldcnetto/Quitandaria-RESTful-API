package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ApiException;
import netto.leonidas.avanade_decola.controller.exception.ConflictException;
import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.Endereco;
import netto.leonidas.avanade_decola.repository.EnderecoRepository;
import netto.leonidas.avanade_decola.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Endereco salvarEndereco(Endereco endereco) {
        // Validação: Verifica se o CEP está vazio ou zero
        if (endereco.getCep() == 0) {
            throw new ValidationException("O CEP não pode ser vazio ou zero.");
        }

        // Validação: Verifica se a cidade está vazia ou nula
        if (endereco.getCidade() == null || endereco.getCidade().trim().isEmpty()) {
            throw new ValidationException("A cidade não pode ser vazia.");
        }

        // Verifica se já existe um endereço com o mesmo CEP
        if (enderecoRepository.existsById(endereco.getCep())) {
            throw new ConflictException("Já existe um endereço com o CEP: " + endereco.getCep());
        }

        return enderecoRepository.save(endereco);
    }

    @Override
    public List<Endereco> listarTodosEnderecos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco buscarEnderecoPorCep(int cep) {
        return enderecoRepository.findById(cep)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado com o CEP: " + cep));
    }

    @Override
    public void deletarEndereco(int cep) {
        // Verifica se o endereço existe antes de tentar deletar
        if (!enderecoRepository.existsById(cep)) {
            throw new ResourceNotFoundException("Endereço não encontrado com o CEP: " + cep);
        }
        enderecoRepository.deleteById(cep);
    }

    @Override
    public List<Endereco> buscarEnderecosPorCidade(String cidade) {
        // Validação: Verifica se a cidade está vazia ou nula
        if (cidade == null || cidade.trim().isEmpty()) {
            throw new ValidationException("A cidade não pode ser vazia.");
        }

        return enderecoRepository.findByCidade(cidade);
    }

    @Override
    public List<Endereco> buscarEnderecosPorTipo(Endereco.TipoEndereco tipo) {
        // Validação: Verifica se o tipo de endereço está nulo
        if (tipo == null) {
            throw new ValidationException("O tipo de endereço não pode ser nulo.");
        }

        return enderecoRepository.findByTipo(tipo);
    }
}