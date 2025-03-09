package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.FornecedorPJ;

public interface FornecedorPJService {
    FornecedorPJ salvarFornecedorPJ(FornecedorPJ fornecedorPJ);
    FornecedorPJ buscarFornecedorPJPorCnpj(String cnpj);
    void deletarFornecedorPJ(String cnpj);
}
