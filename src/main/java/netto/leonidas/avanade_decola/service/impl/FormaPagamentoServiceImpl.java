package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ApiException;
import netto.leonidas.avanade_decola.controller.exception.ConflictException;
import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.FormaPagamento;
import netto.leonidas.avanade_decola.repository.FormaPagamentoRepository;
import netto.leonidas.avanade_decola.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FormaPagamentoServiceImpl implements FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Override
    public FormaPagamento salvarFormaPagamento(FormaPagamento formaPagamento) {
        if (formaPagamento.getDescricao() == null || formaPagamento.getDescricao().trim().isEmpty()) {
            throw new ValidationException("A descrição da forma de pagamento não pode ser vazia.");
        }

        return formaPagamentoRepository.save(formaPagamento);
    }

    @Override
    public List<FormaPagamento> listarTodasFormasPagamento() {
        return formaPagamentoRepository.findAll();
    }

    @Override
    public FormaPagamento buscarFormaPagamentoPorId(int id) {
        return formaPagamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Forma de pagamento não encontrada com o ID: " + id));
    }

    @Override
    public void deletarFormaPagamento(int id) {
        if (!formaPagamentoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Forma de pagamento não encontrada com o ID: " + id);
        }
        formaPagamentoRepository.deleteById(id);
    }

    @Override
    public List<FormaPagamento> buscarFormasPagamentoPorDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new ValidationException("A descrição não pode ser vazia.");
        }

        return formaPagamentoRepository.findByDescricaoContaining(descricao);
    }
}