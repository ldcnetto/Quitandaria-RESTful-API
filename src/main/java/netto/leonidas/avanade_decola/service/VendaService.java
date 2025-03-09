package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.Venda;
import java.time.LocalDateTime;
import java.util.List;

public interface VendaService {
    Venda salvarVenda(Venda venda);
    List<Venda> listarTodasVendas();
    Venda buscarVendaPorId(int id);
    void deletarVenda(int id);
    List<Venda> buscarVendasPorCliente(int idCliente);
    List<Venda> buscarVendasPorFuncionario(int idFuncionario);
    List<Venda> buscarVendasPorPeriodo(LocalDateTime inicio, LocalDateTime fim);
}
