package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.FornecedorPF;

public interface FornecedorPFService {
    FornecedorPF salvarFornecedorPF(FornecedorPF fornecedorPF);
    FornecedorPF buscarFornecedorPFPorCpf(String cpf);
    void deletarFornecedorPF(String cpf);
}