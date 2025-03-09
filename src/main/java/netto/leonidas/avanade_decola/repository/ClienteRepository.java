package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeContaining(String nome);
    Optional<Cliente> findByEmail(String email);
    boolean existsByCpf(String cpf);
    List<Cliente> findByCpfContaining(String cpf);
}
