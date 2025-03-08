package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Integer> {
    List<FormaPagamento> findByDescricaoContaining(String descricao);
}