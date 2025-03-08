package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    List<Funcionario> findByNomeContaining(String nome);
    Funcionario findByCpf(String cpf);
    List<Funcionario> findByCargoId(int idCargo);
}
