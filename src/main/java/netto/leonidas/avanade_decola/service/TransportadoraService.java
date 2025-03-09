package netto.leonidas.avanade_decola.service;

import netto.leonidas.avanade_decola.model.Transportadora;
import java.util.List;

public interface TransportadoraService {
    Transportadora salvarTransportadora(Transportadora transportadora);
    List<Transportadora> listarTodasTransportadoras();
    Transportadora buscarTransportadoraPorId(int id);
    void deletarTransportadora(int id);
    List<Transportadora> buscarTransportadorasPorRazaoSocial(String razaoSocial);
    Transportadora buscarTransportadoraPorCnpj(String cnpj);
}
