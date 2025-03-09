package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.Fornecedor;

import java.util.List;

public interface FornecedorService {
    Fornecedor salvarFornecedor(Fornecedor fornecedor);
    List<Fornecedor> listarTodosFornecedores();
    Fornecedor buscarFornecedorPorId(int id);
    void deletarFornecedor(int id);
    List<Fornecedor> buscarFornecedoresPorRazaoSocial(String razaoSocial);
    Fornecedor buscarFornecedorPorEmail(String email);
}
