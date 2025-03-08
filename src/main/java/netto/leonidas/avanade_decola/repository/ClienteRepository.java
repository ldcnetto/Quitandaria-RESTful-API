package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeContaining(String nome);
    Cliente findByEmail(String email);
}
