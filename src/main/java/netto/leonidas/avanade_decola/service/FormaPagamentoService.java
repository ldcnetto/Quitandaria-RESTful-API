package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.FormaPagamento;
import java.util.List;

public interface FormaPagamentoService {
    FormaPagamento salvarFormaPagamento(FormaPagamento formaPagamento);
    List<FormaPagamento> listarTodasFormasPagamento();
    FormaPagamento buscarFormaPagamentoPorId(int id);
    void deletarFormaPagamento(int id);
    List<FormaPagamento> buscarFormasPagamentoPorDescricao(String descricao);
}
