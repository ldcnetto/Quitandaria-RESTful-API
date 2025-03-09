package netto.leonidas.avanade_decola.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "razao_social", nullable = false, length = 60)
    private String razaoSocial;

    @Column(name = "telefone", nullable = false)
    private long telefone;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "cep_fornecedor")
    private Endereco endereco;

    @Column(name = "n_comercial")
    private int nComercial;

    @OneToOne(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private FornecedorPF fornecedorPF;

    @OneToOne(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private FornecedorPJ fornecedorPJ;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fornecedor")
    private Set<ProdutoFornecedor> produtosFornecedores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getnComercial() {
        return nComercial;
    }

    public void setnComercial(int nComercial) {
        this.nComercial = nComercial;
    }

    public FornecedorPF getFornecedorPF() {
        return fornecedorPF;
    }

    public void setFornecedorPF(FornecedorPF fornecedorPF) {
        this.fornecedorPF = fornecedorPF;
    }

    public FornecedorPJ getFornecedorPJ() {
        return fornecedorPJ;
    }

    public void setFornecedorPJ(FornecedorPJ fornecedorPJ) {
        this.fornecedorPJ = fornecedorPJ;
    }

    public Set<ProdutoFornecedor> getProdutosFornecedores() {
        return produtosFornecedores;
    }

    public void setProdutosFornecedores(Set<ProdutoFornecedor> produtosFornecedores) {
        this.produtosFornecedores = produtosFornecedores;
    }
}
