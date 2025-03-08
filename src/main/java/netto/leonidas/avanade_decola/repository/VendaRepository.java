package netto.leonidas.avanade_decola.repository;

import netto.leonidas.avanade_decola.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {
    List<Venda> findByClienteId(int idCliente);
    List<Venda> findByFuncionarioId(int idFuncionario);
    List<Venda> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
}
