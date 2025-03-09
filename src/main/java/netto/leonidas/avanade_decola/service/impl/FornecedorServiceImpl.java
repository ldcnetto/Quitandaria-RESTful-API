package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ApiException;
import netto.leonidas.avanade_decola.controller.exception.ConflictException;
import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.Fornecedor;
import netto.leonidas.avanade_decola.repository.FornecedorRepository;
import netto.leonidas.avanade_decola.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        if (fornecedor.getRazaoSocial() == null || fornecedor.getRazaoSocial().trim().isEmpty()) {
            throw new ValidationException("A razão social não pode ser vazia.");
        }

        if (fornecedor.getEmail() == null || fornecedor.getEmail().trim().isEmpty()) {
            throw new ValidationException("O email não pode ser vazio.");
        }

        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public List<Fornecedor> listarTodosFornecedores() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Fornecedor buscarFornecedorPorId(int id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado com o ID: " + id));
    }

    @Override
    public void deletarFornecedor(int id) {
        if (!fornecedorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Fornecedor não encontrado com o ID: " + id);
        }
        fornecedorRepository.deleteById(id);
    }

    @Override
    public List<Fornecedor> buscarFornecedoresPorRazaoSocial(String razaoSocial) {
        if (razaoSocial == null || razaoSocial.trim().isEmpty()) {
            throw new ValidationException("A razão social não pode ser vazia.");
        }

        return fornecedorRepository.findByRazaoSocialContaining(razaoSocial);
    }

    @Override
    public Fornecedor buscarFornecedorPorEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new ValidationException("O email não pode ser vazio.");
        }

        return fornecedorRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado com o email: " + email));
    }
}