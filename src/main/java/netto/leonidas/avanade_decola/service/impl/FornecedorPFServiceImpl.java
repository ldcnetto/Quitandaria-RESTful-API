package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ConflictException;
import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.FornecedorPF;
import netto.leonidas.avanade_decola.repository.FornecedorPFRepository;
import netto.leonidas.avanade_decola.service.FornecedorPFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorPFServiceImpl implements FornecedorPFService {

    @Autowired
    private FornecedorPFRepository fornecedorPFRepository;

    @Override
    public FornecedorPF salvarFornecedorPF(FornecedorPF fornecedorPF) {
        if (fornecedorPF.getCpf() == null || fornecedorPF.getCpf().trim().isEmpty()) {
            throw new ValidationException("O CPF não pode ser vazio.");
        }

        if (fornecedorPFRepository.existsById(fornecedorPF.getCpf())) {
            throw new ConflictException("Já existe um fornecedor com o CPF: " + fornecedorPF.getCpf());
        }

        return fornecedorPFRepository.save(fornecedorPF);
    }

    @Override
    public FornecedorPF buscarFornecedorPFPorCpf(String cpf) {
        return fornecedorPFRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado com o CPF: " + cpf));
    }

    @Override
    public void deletarFornecedorPF(String cpf) {
        if (!fornecedorPFRepository.existsById(cpf)) {
            throw new ResourceNotFoundException("Fornecedor não encontrado com o CPF: " + cpf);
        }
        fornecedorPFRepository.deleteById(cpf);
    }
}