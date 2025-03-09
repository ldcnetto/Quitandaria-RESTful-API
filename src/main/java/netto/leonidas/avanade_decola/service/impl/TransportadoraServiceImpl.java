package netto.leonidas.avanade_decola.service.impl;

import netto.leonidas.avanade_decola.controller.exception.ConflictException;
import netto.leonidas.avanade_decola.controller.exception.ResourceNotFoundException;
import netto.leonidas.avanade_decola.controller.exception.ValidationException;
import netto.leonidas.avanade_decola.model.Transportadora;
import netto.leonidas.avanade_decola.repository.TransportadoraRepository;
import netto.leonidas.avanade_decola.service.TransportadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransportadoraServiceImpl implements TransportadoraService {

    @Autowired
    private TransportadoraRepository transportadoraRepository;

    @Override
    public Transportadora salvarTransportadora(Transportadora transportadora) {
        if (transportadora.getRazaoSocial() == null || transportadora.getRazaoSocial().trim().isEmpty()) {
            throw new ValidationException("A razão social não pode ser vazia.");
        }

        if (transportadora.getCnpj() == null || transportadora.getCnpj().trim().isEmpty()) {
            throw new ValidationException("O CNPJ não pode ser vazio.");
        }

        if (transportadoraRepository.existsByCnpj(transportadora.getCnpj())) {
            throw new ConflictException("Já existe uma transportadora com o CNPJ: " + transportadora.getCnpj());
        }

        return transportadoraRepository.save(transportadora);
    }

    @Override
    public List<Transportadora> listarTodasTransportadoras() {
        return transportadoraRepository.findAll();
    }

    @Override
    public Transportadora buscarTransportadoraPorId(int id) {
        return transportadoraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transportadora não encontrada com o ID: " + id));
    }

    @Override
    public void deletarTransportadora(int id) {
        if (!transportadoraRepository.existsById(id)) {
            throw new ResourceNotFoundException("Transportadora não encontrada com o ID: " + id);
        }
        transportadoraRepository.deleteById(id);
    }

    @Override
    public List<Transportadora> buscarTransportadorasPorRazaoSocial(String razaoSocial) {
        if (razaoSocial == null || razaoSocial.trim().isEmpty()) {
            throw new ValidationException("A razão social não pode ser vazia.");
        }

        return transportadoraRepository.findByRazaoSocialContaining(razaoSocial);
    }

    @Override
    public Transportadora buscarTransportadoraPorCnpj(String cnpj) {
        if (cnpj == null || cnpj.trim().isEmpty()) {
            throw new ValidationException("O CNPJ não pode ser vazio.");
        }

        return transportadoraRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new ResourceNotFoundException("Transportadora não encontrada com o CNPJ: " + cnpj));
    }
}