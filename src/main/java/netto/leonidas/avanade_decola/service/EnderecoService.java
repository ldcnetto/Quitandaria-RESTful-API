package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.Endereco;
import java.util.List;

public interface EnderecoService {
    Endereco salvarEndereco(Endereco endereco);
    List<Endereco> listarTodosEnderecos();
    Endereco buscarEnderecoPorCep(int cep);
    void deletarEndereco(int cep);
    List<Endereco> buscarEnderecosPorCidade(String cidade);
    List<Endereco> buscarEnderecosPorTipo(Endereco.TipoEndereco tipo);
}