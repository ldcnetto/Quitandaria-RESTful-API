package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
    List<Fornecedor> findByRazaoSocialContaining(String razaoSocial);
    Optional<Fornecedor> findByEmail(String email);
}
