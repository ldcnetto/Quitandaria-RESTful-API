package netto.leonidas.avanade_decola.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "telefone", nullable = false)
    private long telefone;

    @ManyToOne
    @JoinColumn(name = "cep_cliente", nullable = false)
    private Endereco endereco;

    @Column(name = "n_residencial", nullable = false)
    private int nResidencial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getnResidencial() {
        return nResidencial;
    }

    public void setnResidencial(int nResidencial) {
        this.nResidencial = nResidencial;
    }
}
