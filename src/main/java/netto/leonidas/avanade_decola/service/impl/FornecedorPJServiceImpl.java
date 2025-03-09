package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ApiException;
import netto.leonidas.avanade_decola.controller.exception.ConflictException;
import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.FornecedorPJ;
import netto.leonidas.avanade_decola.repository.FornecedorPJRepository;
import netto.leonidas.avanade_decola.service.FornecedorPJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorPJServiceImpl implements FornecedorPJService {

    @Autowired
    private FornecedorPJRepository fornecedorPJRepository;

    @Override
    public FornecedorPJ salvarFornecedorPJ(FornecedorPJ fornecedorPJ) {
        if (fornecedorPJ.getCnpj() == null || fornecedorPJ.getCnpj().trim().isEmpty()) {
            throw new ValidationException("O CNPJ não pode ser vazio.");
        }

        if (fornecedorPJRepository.existsById(fornecedorPJ.getCnpj())) {
            throw new ConflictException("Já existe um fornecedor com o CNPJ: " + fornecedorPJ.getCnpj());
        }

        return fornecedorPJRepository.save(fornecedorPJ);
    }

    @Override
    public FornecedorPJ buscarFornecedorPJPorCnpj(String cnpj) {
        return fornecedorPJRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado com o CNPJ: " + cnpj));
    }

    @Override
    public void deletarFornecedorPJ(String cnpj) {
        if (!fornecedorPJRepository.existsById(cnpj)) {
            throw new ResourceNotFoundException("Fornecedor não encontrado com o CNPJ: " + cnpj);
        }
        fornecedorPJRepository.deleteById(cnpj);
    }
}