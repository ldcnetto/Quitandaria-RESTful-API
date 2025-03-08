package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, ItemVenda.ItemVendaId> {
    List<ItemVenda> findByVendaId(int idVenda);
    List<ItemVenda> findByProdutoId(int idProduto);
}