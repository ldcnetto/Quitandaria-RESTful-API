package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ApiException;
import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.ProdutoFornecedor;
import netto.leonidas.avanade_decola.repository.ProdutoFornecedorRepository;
import netto.leonidas.avanade_decola.service.ProdutoFornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoFornecedorServiceImpl implements ProdutoFornecedorService {

    @Autowired
    private ProdutoFornecedorRepository produtoFornecedorRepository;

    @Override
    public ProdutoFornecedor salvarProdutoFornecedor(ProdutoFornecedor produtoFornecedor) {
        return produtoFornecedorRepository.save(produtoFornecedor);
    }

    @Override
    public List<ProdutoFornecedor> listarTodosProdutosFornecedores() {
        return produtoFornecedorRepository.findAll();
    }

    @Override
    public void deletarProdutoFornecedor(ProdutoFornecedor.ProdutoFornecedorId id) {
        if (!produtoFornecedorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto do fornecedor não encontrado com o ID: " + id);
        }
        produtoFornecedorRepository.deleteById(id);
    }

    @Override
    public List<ProdutoFornecedor> buscarProdutosPorFornecedor(int idFornecedor) {
        return produtoFornecedorRepository.findByFornecedorId(idFornecedor);
    }

    @Override
    public List<ProdutoFornecedor> buscarFornecedoresPorProduto(int idProduto) {
        return produtoFornecedorRepository.findByProdutoId(idProduto);
    }
}