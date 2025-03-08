package netto.leonidas.avanade_decola.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Cargos")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "descricao", nullable = false, length = 40)
    private String descricao;

    @OneToMany(mappedBy = "cargo")
    private Set<Funcionario> funcionarios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
