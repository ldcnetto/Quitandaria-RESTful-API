package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    List<Cargo> findByDescricaoContaining(String descricao);
}
