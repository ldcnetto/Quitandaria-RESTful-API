package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByDescricaoContaining(String descricao);
    List<Produto> findByPrecoBetween(BigDecimal precoInicial, BigDecimal precoFinal);
}
