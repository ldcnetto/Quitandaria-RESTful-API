package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
    List<Fornecedor> findByRazaoSocialContaining(String razaoSocial);
    Fornecedor findByEmail(String email);
}
