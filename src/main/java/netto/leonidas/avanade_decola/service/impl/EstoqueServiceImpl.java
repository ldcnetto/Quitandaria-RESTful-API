package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ApiException;
import netto.leonidas.avanade_decola.controller.exception.ConflictException;
import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.Estoque;
import netto.leonidas.avanade_decola.repository.EstoqueRepository;
import netto.leonidas.avanade_decola.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public Estoque salvarEstoque(Estoque estoque) {
        // Validação: Verifica se o ID do produto está vazio ou zero
        if (estoque.getIdProduto() == 0) {
            throw new ValidationException("O ID do produto não pode ser vazio ou zero.");
        }

        // Validação: Verifica se a quantidade é negativa
        if (estoque.getQuantidade() < 0) {
            throw new ValidationException("A quantidade não pode ser negativa.");
        }

        // Verifica se já existe um estoque para o mesmo produto
        if (estoqueRepository.existsByProdutoId((estoque.getIdProduto()))) {
            throw new ConflictException("Já existe um estoque para o produto com ID: " + estoque.getIdProduto());
        }

        return estoqueRepository.save(estoque);
    }

    @Override
    public List<Estoque> listarTodosEstoques() {
        return estoqueRepository.findAll();
    }

    @Override
    public Estoque buscarEstoquePorProduto(int idProduto) {
        return estoqueRepository.findByProdutoId(idProduto)
                .orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado para o produto com ID: " + idProduto));
    }

    @Override
    public void deletarEstoque(int idProduto) {
        // Verifica se o estoque existe antes de tentar deletar
        if (!estoqueRepository.existsByProdutoId(idProduto)) {
            throw new ResourceNotFoundException("Estoque não encontrado para o produto com ID: " + idProduto);
        }
        estoqueRepository.deleteById(idProduto);
    }

    @Override
    public List<Estoque> buscarEstoquesComQuantidadeAbaixoDe(int quantidade) {
        // Validação: Verifica se a quantidade é negativa
        if (quantidade < 0) {
            throw new ValidationException("A quantidade não pode ser negativa.");
        }

        return estoqueRepository.findByQuantidadeLessThan(quantidade);
    }
}