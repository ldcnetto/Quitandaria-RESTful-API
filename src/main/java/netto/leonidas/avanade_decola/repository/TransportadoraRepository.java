package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Integer> {
    List<Transportadora> findByRazaoSocialContaining(String razaoSocial);
    Optional<Transportadora> findByCnpj(String cnpj);
    boolean existsByCnpj(String cnpj);
}
