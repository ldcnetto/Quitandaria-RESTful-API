package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.Venda;
import netto.leonidas.avanade_decola.repository.VendaRepository;
import netto.leonidas.avanade_decola.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Override
    public Venda salvarVenda(Venda venda) {
        if (venda.getCliente() == null) {
            throw new ValidationException("O cliente da venda não pode ser nulo.");
        }

        if (venda.getFuncionario() == null) {
            throw new ValidationException("O funcionário da venda não pode ser nulo.");
        }

        if (venda.getDataHora() == null) {
            throw new ValidationException("A data e hora da venda não podem ser nulas.");
        }

        return vendaRepository.save(venda);
    }

    @Override
    public List<Venda> listarTodasVendas() {
        return vendaRepository.findAll();
    }

    @Override
    public Venda buscarVendaPorId(int id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venda não encontrada com o ID: " + id));
    }

    @Override
    public void deletarVenda(int id) {
        if (!vendaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Venda não encontrada com o ID: " + id);
        }
        vendaRepository.deleteById(id);
    }

    @Override
    public List<Venda> buscarVendasPorCliente(int idCliente) {
        return vendaRepository.findByClienteId(idCliente);
    }

    @Override
    public List<Venda> buscarVendasPorFuncionario(int idFuncionario) {
        return vendaRepository.findByFuncionarioId(idFuncionario);
    }

    @Override
    public List<Venda> buscarVendasPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        if (inicio == null || fim == null) {
            throw new ValidationException("As datas de início e fim não podem ser nulas.");
        }

        return vendaRepository.findByDataHoraBetween(inicio, fim);
    }
}