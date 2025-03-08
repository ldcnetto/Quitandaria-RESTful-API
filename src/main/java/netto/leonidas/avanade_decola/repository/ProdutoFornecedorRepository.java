package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.ProdutoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoFornecedorRepository extends JpaRepository<ProdutoFornecedor, ProdutoFornecedor.ProdutoFornecedorId> {
    List<ProdutoFornecedor> findByFornecedorId(int idFornecedor);
    List<ProdutoFornecedor> findByProdutoId(int idProduto);
}