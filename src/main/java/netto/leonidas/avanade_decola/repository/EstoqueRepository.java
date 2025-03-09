package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
    Optional<Estoque> findByProdutoId(int idProduto);
    List<Estoque> findByQuantidadeLessThan(int quantidade);

    boolean existsByProdutoId(int attr0);
}
