package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Integer> {
    List<Transportadora> findByRazaoSocialContaining(String razaoSocial);
    Transportadora findByCnpj(String cnpj);
}
