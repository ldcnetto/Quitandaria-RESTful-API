package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    List<Endereco> findByCidade(String cidade); // Buscar endereços por cidade
    List<Endereco> findByTipo(Endereco.TipoEndereco tipo); // Buscar endereços por tipo
}