package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.FornecedorPF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorPFRepository extends JpaRepository<FornecedorPF, String> {
    FornecedorPF findByCpf(String cpf);
}
