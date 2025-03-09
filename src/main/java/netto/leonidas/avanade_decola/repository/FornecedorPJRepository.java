package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.FornecedorPJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FornecedorPJRepository extends JpaRepository<FornecedorPJ, String> {
    Optional<FornecedorPJ> findByCnpj(String cnpj);
}
